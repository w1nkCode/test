package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-06-01 8:42
 */
object Scala09_Match {
  def main(args: Array[String]): Unit = {

    val list = List(
      ("a",1),
      ("b",2)
    )

    list.map(
      t => {
        (t._1,t._2 * 2)
      }
    )
    val newList = list.map {
     case (word, count) => {
       (word, count * 2)
     }
    }
    println(newList)
  }
}
