package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
/**
 * @author ygCode
 * @create 2020-06-11 11:20
 */
object SparkSQL01_Test {
  def main(args: Array[String]): Unit = {
    //创建环境对象
     val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
     import spark.implicits._

    //逻辑操作
    // 将DF转换为临时视图
    val jsonDF = spark.read.json("input/user.json")
    jsonDF.createOrReplaceTempView("user")
    spark.sql("select * from user").show
    // TODO DSL
    jsonDF.select("name","age").show
    jsonDF.select('name,'age).show

    val rdd = spark.sparkContext.makeRDD(List(
      (1,"zhangsan",30),
      (2,"lisi",20),
      (3,"wangwu",40)
    ))
    val df: DataFrame = rdd.toDF("id","name","age")
    val dfToRDD: RDD[Row] = df.rdd

    //TODO RDD <=> DataSet
    val userRDD = rdd.map{
      case(id,name,age) =>{
        User(id,name,age)
      }
    }
    val userDS: Dataset[User] = userRDD.toDS()
    val dsToRdd = userDS.rdd
    //TODO DataFrame <=> DataSet
    val dfToDS: Dataset[User] = df.as[User]
    val dsToDF: DataFrame = dfToDS.toDF()

    rdd.foreach(println)
    df.show()
    userDS.show
    //释放对象
    spark.stop()
  }

  case class User(id:Int,name:String,age:Int)
}
