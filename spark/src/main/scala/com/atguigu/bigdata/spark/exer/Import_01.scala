package com.atguigu.bigdata.spark.exer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-11 16:06
 */
object Import_01 {
  def main(args: Array[String]): Unit = {
    // TODO 1.准备Spark环境
    //setMaster:设定Spark环境的位置
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    //TODO 2. 建立和Spark的连接
    val sc = new SparkContext(sparkConf)

    //实现业务操作
    // 读取指定目录下的数据文件
    //RDD 更适合并行计算的数据模型
    val fileRDD: RDD[String] = sc.textFile("input/word.txt")
    //将读取的数据进行扁平化操作，切分单词
    //fileRDD.flatMap(line=>{line.split(" ")})
    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))
    //将分词后的数据进行分组
    val groupRDD: RDD[(String, Iterable[String])] = wordRDD.groupBy(word=>word)


    //将分组后的数据进行聚合(word,Iterable) => (word,count)
    val mapRDD: RDD[(String, Int)] = groupRDD.map {
      case (word, iter) => {
        (word, iter.size)
      }
    }


    //将聚合的结果采集后打印到控制台
    val wordCountArray: Array[(String, Int)] = mapRDD.collect()
    println(wordCountArray.mkString(","))

    //释放连接
    sc.stop()
  }
}
