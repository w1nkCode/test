package com.atguigu.bigdata.scala

import java.io.{OutputStreamWriter, PrintWriter}
import java.net.Socket

/**
 * @author ygCode
 * @create 2020-05-23 9:13
 */
object Client {
  def main(args: Array[String]): Unit = {
    //获取一个本机客户端
    val client = new Socket("localhost",9999)
    //获取一个输出流
    val out = new PrintWriter(
      new OutputStreamWriter(
        client.getOutputStream,"UTF-8"
      )
    )
    out.write("scala,java")
    out.flush()
    out.close()
    client.close()
  }
}
