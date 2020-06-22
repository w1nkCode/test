package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @author ygCode
 * @create 2020-06-11 11:20
 */
object SparkSQL04_Mock{
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    //创建环境对象
     val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder()
      .enableHiveSupport()
      .config(sparkConf).getOrCreate()

    import spark.implicits._
    spark.sql("use atguigu200213").show()
    spark.sql(
      """
        |CREATE TABLE `user_visit_action`(
        |  `date` string,
        |  `user_id` bigint,
        |  `session_id` string,
        |  `page_id` bigint,
        |  `action_time` string,
        |  `search_keyword` string,
        |  `click_category_id` bigint,
        |  `click_product_id` bigint,
        |  `order_category_ids` string,
        |  `order_product_ids` string,
        |  `pay_category_ids` string,
        |  `pay_product_ids` string,
        |  `city_id` bigint)
        |row format delimited fields terminated by '\t'
         """.stripMargin)

    spark.sql(
      """
        |load data local inpath 'input/user_visit_action.txt' into table atguigu200213.user_visit_action
        """.stripMargin
    )
    spark.sql(
      """
        |
        |""".stripMargin
    )
    //释放对象
    spark.stop()
  }
}
