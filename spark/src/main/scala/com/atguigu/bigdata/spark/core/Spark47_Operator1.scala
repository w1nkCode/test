package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-01 16:06
 */
object Spark47_Operator1 {
  def main(args: Array[String]): Unit = {

    // TODO Spark - WordCount
    // TODO Spark是一个计算框架
    // TODO 开发人员是使用Spark框架的API实现计算功能。

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext(sparkConf)

    //TODO 1 .获取原始数据
    val dataRDD = sc.textFile("input/agent.log")
    //TODO 2 将原始数据进行结构的转换，方便统计
    //((省份-广告)，1)
   val mapRDD : RDD [(String,Int)]= dataRDD.map(
      line =>{
        val datas = line.split(" ")
        (datas(1)+"-" + datas(4),1)
      }
    )
    //TODO 将相同key的数据进行分组聚合
    //((省份-广告)，sum)
    val reduceRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

    //TODO 将聚合后的结果进行结构的转换
    val mapRDD1: RDD[(String, (String, Int))] = reduceRDD.map {
      case (key, sum) => {
        val keys = key.split("-")
        (keys(0), (keys(1), sum))
      }
    }

    // TODO 将相同的省份的数据分在一个组中
   val groupRDD: RDD[(String,Iterable[(String,Int)])] = mapRDD1.groupByKey()
    //TODO 将分组后的数据进行排序(降序)，取前三 TOP3

    val sortRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(iter => {
      iter.toList.sortWith(
        (left, right) => {
          left._2 > right._2
        }
      ).take(3)
    })
    //TODO 将数据采集才控制台
    val result: Array[(String, List[(String, Int)])] = sortRDD.collect()
    result.foreach(println)
    sc.stop()
  }
}