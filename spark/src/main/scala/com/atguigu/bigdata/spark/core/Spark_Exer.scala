package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author ygCode
 * @create 2020-06-08 9:03
 */
object Spark_Exer {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File - RDD")
    val sc = new SparkContext((sparkConf))

    //TODO 1 ,groupBy
    //TODO 2 ,groupByKey
    //TODO 3 ,reduceByKey
    //TODO 4 ,aggergateByKey
    //TODO 5 ,foldByKey
    //TODO 6 ,combineByKey
    //TODO 7 ,countByKey
    //TODO 8 ,countByValue
  //  val rdd = sc.makeRDD(List("a","a","b","a","b"))

    //TODO 9,reduce :结构不对就要转换
  //  val mapRDD: RDD[Map[String,Int]] = rdd.map(word=>Map[String,Int]((word,1)))

 //   val map: String = rdd.reduce(
   //   (map1,map2) => {
      //  map1.foldLeft(map2)(
        //  (map,kv)=>{
        //    val word =kv._1
         //   val count = kv._2
          //  map.updated(word,map.getOrElse(word,0) + count)
         // }
    //    )
 //     }
 //   )

    sc.stop()
  }
}
