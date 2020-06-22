package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-05-28 9:30
 */
object Scala02_Test {
  //声明方法def
  //名称(参数列表)：类型
  //参数名：参数类型
  //方法赋值
  def main(args: Array[String]): Unit = {
    //方法体
    println("Hello Scala")
    //调用方法
    println(Scala02_Test.test())
  }
  def test() : String = {
   return "test"
    //var name : String = "zhangsan"
    var name = "zhangsan"//类型推断

    val age = 10
    return "name"
  }
}
