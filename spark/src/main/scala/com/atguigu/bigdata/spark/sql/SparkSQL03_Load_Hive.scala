package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author ygCode
 * @create 2020-06-11 11:20
 */
object SparkSQL03_Load_Hive{
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    //创建环境对象
     val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder()
      .enableHiveSupport()
      .config(sparkConf).getOrCreate()

    //spark.sql("create table aa(id int)")
    //spark.sql("show tables").show()
    //spark.sql("load data local inpath 'input/id.txt' into table aa")
    //spark.sql("select * from aa").show()
    spark.sql("create table databases(id int)")
    spark.sql("show databases").show()


    //释放对象
    spark.stop()
  }
}
