package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-01 16:06
 */
object Spark46_Test {
  def main(args: Array[String]): Unit = {

    // TODO Spark - WordCount
    // Spark是一个计算框架
    // 开发人员是使用Spark框架的API实现计算功能。

    // TODO 1. 准备Spark环境
     //setMaster : 设定Spark环境的位置
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")

    // TODO 2. 建立和Spark的连接
    val sc = new SparkContext(sparkConf)

    //val rdd = sc.makeRDD(List(1,1,2,2),2)
    //val resule = rdd.mapPartitions(
    //  iter => {
    //    val len = iter.length
    //    iter.hasNext
    //   List((iter.next(), iter.length)).iterator
  //  iter
  //    }
   // )
    //println(resule.collect().mkString(","))


    val iter: Iterator[Int] = List(1,2,3,4).iterator
    val len: Int = iter.length
    while(iter.hasNext){
      println(iter.next())
    }
    // TODO 4. 释放连接
    sc.stop()
  }
}