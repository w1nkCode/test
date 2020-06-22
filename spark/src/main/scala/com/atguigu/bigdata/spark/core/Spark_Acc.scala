package com.atguigu.bigdata.spark.core

import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-08 11:53
 */
object Spark_Acc {
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
    val rdd = sc.makeRDD(List(1,2,3,4))
    val sum: LongAccumulator = sc.longAccumulator("sum")
    rdd.foreach(
      num => {
        sum.add(num)
      }
  )
    println(sum.value)
    sc.stop()
  }
}
