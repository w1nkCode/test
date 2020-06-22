package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-05-28 15:38
 */
object Test_lazy {
  def main(args: Array[String]): Unit = {
    def fun19(i: Int) = {
      println("zhangsan")
      i
    }

    lazy  val m = fun19(10)
    println("=================")
    println(m)
  }
}
