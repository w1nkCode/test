package com.atguigu.bigdata.spark.streaming.controller

import com.atguigu.bigdata.spark.streaming.service.MockDataService
import com.atguigu.summer.framework.core.TController

class MockDataController extends TController{

    private val mockDataService = new MockDataService

    override def execute(): Unit = {
        val result = mockDataService.analysis()
    }
}
