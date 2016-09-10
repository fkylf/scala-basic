package com.horizonio.spark.basic.simple001

/**
  * Created by zqh on 2016/9/10
  */
object SequencePattern {

  def main(args: Array[String]): Unit = {
    val list = List("spark", "hive", "sparksql")


    val arr = Array("sparkR", "sparkstreaming", "sparkMLlib")

    def sequenceShow(p: Any) = p match {
      case Array(first, second, _*) => first + "," + second
      case List(_, second, _*) => second
      case _ => "other"
    }

    println(sequenceShow(list))
    println(sequenceShow(arr))

  }

}
