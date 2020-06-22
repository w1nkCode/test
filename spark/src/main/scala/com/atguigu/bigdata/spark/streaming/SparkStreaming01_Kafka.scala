package com.atguigu.bigdata.spark.streaming

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author ygCode
 * @create 2020-06-15 18:34
 */
object SparkStreaming01_Kafka {
  def main(args: Array[String]): Unit = {
    // TODO Spark环境
    // SparkStreaming使用核数最少是2个
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
    val ssc = new StreamingContext(sparkConf,Seconds(3))
    // TODO 使用SparkStreaming读取Kafka的数据

    // Kafka的配置信息
    val kafkaPara: Map[String, Object] = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "hadoop202:9092,hadoop203:9092,hadoop204:9092",
      ConsumerConfig.GROUP_ID_CONFIG -> "atguigu11",
      "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
      "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
    )
    val kafkaDStream: InputDStream[ConsumerRecord[String, String]] =
      KafkaUtils.createDirectStream[String, String](
        ssc,
        LocationStrategies.PreferConsistent,
        ConsumerStrategies.Subscribe[String, String](Set("atguigu"), kafkaPara)
      )
    val valueDStream: DStream[String] = kafkaDStream.map(record => record.value())

    valueDStream.flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)
      .print()

    ssc.start()
    // 等待采集器的结束
    ssc.awaitTermination()
//    ssc.stop()
  }
}
