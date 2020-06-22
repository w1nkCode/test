package com.atguigu.bigdata.scala

/**
 * @author ygCode
 * @create 2020-05-28 14:44
 */
object Test_sss {
  def main(args: Array[String]): Unit = {
    def fun4(s: String, f: (String) => Boolean) = {
      val strings = s.split(" ")
      var result = ""
      for (word <- strings) {
        if (f(word)) {
          result += ", " + word
        }
      }
      result.substring(2)
    }

    val result4 = fun4("hello world scala spark", (s: String) => {s.startsWith("s") })
    println(result4) //scala, spark
  }

}
