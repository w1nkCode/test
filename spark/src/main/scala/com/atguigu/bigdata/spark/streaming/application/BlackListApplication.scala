package com.atguigu.bigdata.spark.streaming.application

import com.atguigu.bigdata.spark.streaming.controller.BlackListController
import com.atguigu.summer.framework.core.TApplication

object BlackListApplication extends App with TApplication{

    start("sparkStreaming") {
        val controller = new BlackListController
        controller.execute()
    }
}
