package com.horizonio.spark.basic.simple001

/**
  * Created by zqh on 2016/9/10
  */
object CaseClassDemo extends App{

  for(i <- 1 to 100){
    i match {
      case 10=>println(10)
      case 50=>println(50)
      case 80=>println(80)
      case _ if(i%4==0)=>println(i+":能被4整除！")
      case _ =>
    }
  }


}
