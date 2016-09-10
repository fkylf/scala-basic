package com.horizonio.spark.core

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by zqh  on 2016/8/7
  */
trait HdfsWriteAppT extends Serializable {
  private val serialVersionUID: Long = 3495300759679611812L

  /**
    * 从指定的目录加载hdfs文件返回rdd
    *
    * @return
    */
  def writeToHdfs(sparkContext: SparkContext,rdd:RDD[String],outputDir:String);


}
