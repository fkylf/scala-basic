package com.horizonio.spark.core

/**
  * Created by zqh  on 2016/8/7
  */
trait TypeConversionT {
  def parseInt(str: String): Int = {
    try {
      str.toInt
    } catch {
      case ex: Exception => 0
    }
  }


  def parseDouble(str: String): Double = {
    try {
      str.toDouble
    } catch {
      case ex: Exception => 0
    }
  }
}
