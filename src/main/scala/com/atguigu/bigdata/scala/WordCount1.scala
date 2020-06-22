package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-05-29 8:38
 */
object WordCount1 {
  def main(args: Array[String]): Unit = {
    val dataList = List("hello scala","hello spark","hive hadoop")
    val words = dataList.flatMap(string=>{string.split(" ")})
  }
}
