package com.horizonio.spark.core

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by zqh  on 2016/8/7
  */
trait HdfsReadAppT {
  /**
    * 从指定的目录加载hdfs文件返回rdd
    *
    * @return
    */
  def readFromHdfs(sparkContext: SparkContext, path: String): RDD[String]

}
