package com.atguigu.bigdata.scala

import scala.collection.mutable.ListBuffer

/**
 * @author ygCode
 * @create 2020-05-28 16:09
 */
object Scala_Seq1 {
  def main(args: Array[String]): Unit = {

    // Scala - 集合 - Seq - 可变
    val buffer: ListBuffer[Int] = ListBuffer(1,2,3,4)

    // 增加数据
    //buffer.append(5,6,7)
    //buffer.insert(2,8)

    // 修改
    //buffer.update(1,9)
    //buffer(1) = 9

    // 删除数据
    //buffer.remove(1)
    buffer.remove(1,3)

    println(buffer)
    buffer.foreach(println)
    buffer.mkString(",")

  }
}
