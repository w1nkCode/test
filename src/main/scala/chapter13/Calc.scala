package chapter13

/**
 * @author ygCode
 * @create 2020-06-01 11:00
 */
object Calc {
  def main(args: Array[String]): Unit = {
    val num =5
    var sum = 0
    val start =System.currentTimeMillis()
    for(i <- 1 to num) {
      new Thread(
      new Runnable {
        sum = sum + i * 2
        Thread.sleep(i * 100)

        override def run(): Unit = {}
      }
      ).start()
    }
    val end =System.currentTimeMillis()
    println(
      s"""
        | 计算结果为： $sum,耗时： ${end-start}ms
        """.stripMargin)
  }
}
