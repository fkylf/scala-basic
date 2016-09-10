package com.horizonio.spark.basic.simple001

/**
  * Created by zqh on 2016/9/10
  */
object VariablePattern {

  def main(args: Array[String]): Unit = {

    def patternShow(x: Any) = x match {
      case x if (x == 5) => x
      case x if (x == "Scala") => x
      case _ =>
    }

    println(patternShow(5))

    println(patternShow("Scala"))

  }

}
