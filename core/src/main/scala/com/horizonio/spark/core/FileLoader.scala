package com.horizonio.spark.core

import java.io.InputStream
import java.util.Properties

/**
  * Created by zqh  on 2016/9/1
  */
object FileLoader {
  def loadProperties(path: String): Properties = {
    val properties = new Properties()
    val is: InputStream = getClass.getClassLoader.getResourceAsStream(path)
    properties.load(is)
    properties
  }

  def main(args: Array[String]) {
    println(loadProperties("spm/config-online.properties").get("orderPath"))
  }


}
