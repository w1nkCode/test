package com.atguigu.bigdata.spark.core

import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
 * @author ygCode
 * @create 2020-06-08 11:53
 */
object Spark_MyWordCountAccmulator {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext((sparkConf))


    //val sum = rdd.reduce(_+_)
    //println("sum="+sum)


    //var sum = 0
   // rdd.foreach{
    //  case (word,count)=>{
    //    sum =sum +count
   //   }
   // }
   // println("(a,"+sum+")")
   //TODO 累加器
    val rdd = sc.makeRDD(List("hello scala","hello","spark","scala"))
    //TODO 创建累加器
    val acc = new MyWordCountAccumulator
    //TODO 注册累加器
    sc.register(acc)
    //TODO 使用累加器
    rdd.flatMap(_.split(" ")).foreach{
      word => {
        acc.add(word)
      }
    }
    //TODO 获取累加器的值
    println(acc.value)



    sc.stop()
  }
class MyWordCountAccumulator extends AccumulatorV2[String, mutable.Map[String,Long]] {
  var map: mutable.Map[String, Long] = mutable.Map()

  // TODO 累加器是否为初始状态
  override def isZero: Boolean = {
    map.isEmpty
  }

  override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = {
    new MyWordCountAccumulator
  }

  override def reset(): Unit = {
    map.clear()
  }

  override def add(word: String): Unit = {
    map(word) = map.getOrElse(word, 0L) + 1L
  }

  override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {
    val map1 = map
    val map2 = other.value
    map = map1.foldLeft(map2)(
      ( innerMap, kv ) => {
        innerMap(kv._1) = innerMap.getOrElse(kv._1, 0L) + kv._2
        innerMap
      }
    )
  }

  override def value: mutable.Map[String, Long] = map
}
}

