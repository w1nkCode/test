package com.atguigu.bigdata.spark.streaming.controller

import com.atguigu.bigdata.spark.streaming.service.BlackListService
import com.atguigu.summer.framework.core.TController

class BlackListController extends TController{

    private val blackListService = new BlackListService

    override def execute(): Unit = {
        val result = blackListService.analysis()
    }
}
