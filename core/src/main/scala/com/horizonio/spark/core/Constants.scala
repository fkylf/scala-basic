package com.horizonio.spark.core

import java.util.TimeZone

import org.joda.time.{DateTime, DateTimeZone}

/**
  * Created by zqh  on 2016/8/7
  */
object Constants {

  val timeFormatOne="yyyy-MM-dd HH:mm:ss"

  var enp: Array[Byte] = Array[Byte](1)
  val HiveSeparatorU001: String = new String(enp)

  //时区
  val zone: TimeZone = TimeZone.getTimeZone("Asia/Shanghai");

  //T-1时间格式yyyy/MM/dd目录
  val dateDirMinusDays1 = new DateTime().minusDays(1).withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")

  /**
    * 获取距离当天多少天前的目录yyyy/MM/dd
    *
    * @param day
    */
  def getBeforeDayDir(day: Int): String = {
    new DateTime().minusDays(day).withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")
  }

  /**
    * 获取距离当天多少天后的目录yyyy/MM/dd
    *
    * @param day
    */
  def getAfterDayDir(day: Int): String = {
    new DateTime().plusDays(day).withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")
  }


  /**
    * 获取当天日期的目录
    */
  def getCurrentDayDir(): String = {
    new DateTime().withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")
  }


}
