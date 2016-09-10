package com.horizonio.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by zqh  on 2016/8/7
  */
trait HdfsBaseApp extends Serializable {
  private val serialVersionUID: Long = 3495300759679611811L

  /**
    * 初始化配置
    *
    * @param args
    * @return
    */
  def initConfig(args: Array[String]): SparkConf

  /**
    * 初始化
    *
    * @param sparkConf
    * @return
    */
  def init(sparkConf: SparkConf): SparkContext;

  /**
    * 处理rdd
    *
    * @param sparkContext
    */
  def process(sparkContext: SparkContext)

  /**
    * 主入口
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val sparkConf = initConfig(args) //加载spark配置
    val sc = init(sparkConf) //初始化sc
    process(sc) //处理读取的hdfs文件
    sc.stop() //停止sc
  }

}
