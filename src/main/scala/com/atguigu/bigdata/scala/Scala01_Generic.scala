package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-06-01 8:52
 */
object Scala01_Generic {
  def main(args: Array[String]): Unit = {
    //TODO泛型
    //TODOscala中声明泛型，采用的是中括号
    //TODO 泛型不可变
    //TODO 泛型协变：将泛型作为类型的一部分来理解
    val a1 : AAA[User] = new AAA[User]
    val a2 : BBB[User] = new BBB[User]
  }
  class AAA[T] {

  }
  class BBB[+T]{

  }
  class Parent {

  }
  class User extends Parent {

  }
  class SubUser extends User {

  }
}
