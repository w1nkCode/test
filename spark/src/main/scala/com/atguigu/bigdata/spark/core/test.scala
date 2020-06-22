package com.atguigu.bigdata.spark.core

/**
 * @author ygCode
 * @create 2020-06-08 9:59
 */
object test {

    def main(args: Array[String]): Unit = {
      var map = Map[Int, String]()
      map += (1 -> "one", 2 -> "two")
      println(map.getOrElse(1, "default"))
      println(map.getOrElse(2, "default"))
      println(map.getOrElse(3, "default"))
    }

}
