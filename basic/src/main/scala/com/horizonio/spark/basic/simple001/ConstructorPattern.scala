package com.horizonio.spark.basic.simple001

/**
  * Created by zqh on 2016/9/10
  */

case class Person(name:String,age:Int,gender:Boolean)

object ConstructorPattern {

  def main(args:Array[String]):Unit={
    val p=new Person("nyz",27,false)
    val p1=new Person("kk",27,true)
    def constructorPattern(p:Person)=p match {
      case Person(name,age,_)=>"name="+name+","+"age="+age
      case _=>"Other"
    }

    println(constructorPattern(p))



  }

}
