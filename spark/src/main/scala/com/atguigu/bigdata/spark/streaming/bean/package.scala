package com.atguigu.bigdata.spark.streaming

package object bean {

    case class Ad_Click_Log( ts:String, area:String, city:String, userid:String, adid:String )
}
