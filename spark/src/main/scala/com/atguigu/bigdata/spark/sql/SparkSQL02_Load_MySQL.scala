package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
 * @author ygCode
 * @create 2020-06-11 11:20
 */
object SparkSQL02_Load_MySQL{
  def main(args: Array[String]): Unit = {
    //创建环境对象
     val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
     import spark.implicits._

    //逻辑操作
    spark.read.format("jdbc")
      .option("url", "jdbc:mysql://linux1:3306/spark-sql")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123123")
      .option("dbtable", "user")
      .load().show




    //释放对象
    spark.stop()
  }

  case class User(id:Int,name:String,age:Int)
}
