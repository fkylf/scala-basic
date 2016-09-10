package com.horizonio.spark.basic.simple001

/**
  * Created by zqh on 2016/9/10
  */
object ConstantPattern {

  def main(args: Array[String]): Unit = {


    def partternShow(x:Any)=x match {
      case 5=>""
      case true=>"真"
      case "test"=>"字符串"
      case null=>"null 值"
      case Nil=>"空列表"
      case _=>"其他常量"
    }

    println(partternShow(5))
    println(partternShow(true))
    println(partternShow(List()))
    println(partternShow(null))

  }

}
