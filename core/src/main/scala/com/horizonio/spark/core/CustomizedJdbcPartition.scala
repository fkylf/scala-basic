package com.horizonio.spark.core

import org.apache.spark.Partition

/**
  * Created by zqh  on 2016/8/29
  */
class CustomizedJdbcPartition (idx: Int, parameters: Map[String, Object]) extends Partition {
  override def index = idx
  val partitionParameters=parameters
}
