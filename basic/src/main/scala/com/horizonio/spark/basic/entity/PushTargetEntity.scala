package com.horizonio.spark.basic.entity

/**
  * Created by zqh  on 2016/9/5
  */
case class PushTargetEntity(taskId: String,
                            userId: String,
                            serialId: String,
                            createTime: String,
                            pushCompleteStatus: String,
                            orderTime: String,
                            sparkHandleTime: String,
                            stormHandleTime: String)
