package com.atguigu.bigdata.spark.exer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-11 16:06
 */
object mapValues{
  def main(args: Array[String]): Unit = {
    // TODO 1.准备Spark环境
    //setMaster:设定Spark环境的位置
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    //TODO 2. 建立和Spark的连接
    val sc = new SparkContext(sparkConf)

    //实现业务操作
    // mapValues 仅对value进行处理，key不变
    val rdd1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",2),("b",1)))
    println(rdd1.mapValues(_ + 1).collect().mkString(","))

    //释放连接
    sc.stop()
  }
}
