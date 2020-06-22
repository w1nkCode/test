package com.atguigu.bigdata.scala

import java.io.{BufferedReader, InputStreamReader}
import java.net.ServerSocket

/**
 * @author ygCode
 * @create 2020-05-23 9:13
 */
object Server {
  def main(args: Array[String]): Unit = {
    //创建一个服务器并指定端口号
    val server = new ServerSocket(9999)
    //获取客户端
    val socket =server.accept()
    //获取一个输入流
    val reader = new BufferedReader(
      new InputStreamReader(
        socket.getInputStream,"UTF-8"
      )
    )
    //读取
    val unit = reader.readLine()
    println(unit)
  }
}
