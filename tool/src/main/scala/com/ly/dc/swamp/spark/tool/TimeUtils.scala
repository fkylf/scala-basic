package com.horizonio.swamp.spark.tool

import java.util.TimeZone

import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import org.joda.time.{DateTime, DateTimeZone}

/**
  * Created by zqh  on 2016/9/5
  */
object TimeUtils {

  val zone: TimeZone = TimeZone.getTimeZone("Asia/Shanghai");
  val defaultFommater = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.forTimeZone(zone))

  def getDayFilePath(today: DateTime): String = today.withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")

  def getDayFilePath(basePath: String, today: DateTime): String = basePath + getDayFilePath(today)

  def getMonthFilePath(today: DateTime): String = today.withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM")

  def getYesterDayFilePath(): String = new DateTime().minusDays(1).withZone(DateTimeZone.forTimeZone(zone)).toString("yyyy/MM/dd")

  def getYesterDayFilePath(basePath: String): String = basePath + getYesterDayFilePath()

  def getPreDateTime(preDay: Int): DateTime = new DateTime().withZone(DateTimeZone.forTimeZone(zone)).minusDays(preDay);

  def getPreDateTime(): DateTime = getPreDateTime(1)

  def parseDateTime(dateString: String): DateTime = {
    parseDateTime(dateString, defaultFommater)
  }

  def parseDateTime(dateString: String, dateTimeFormatter: DateTimeFormatter): DateTime = {
    try {
      DateTime.parse(dateString, dateTimeFormatter)
    } catch {
      case ex: Exception => null
    }
  }

  /**
    * 获取指定时间字符串之后minutes分钟的 Timestamp
    *
    * @param srcTime
    * @param minutes
    * @return
    */
  def getAfterTimestamp(srcTime: String, minutes: Int): String = {
    val dateTime = parseDateTime(srcTime)
    val dateTimeR = dateTime.plusMinutes(minutes)
    dateTimeR.toString("yyyy-MM-dd HH:mm:ss")
  }

  /**
    * 获取指定时间字符串之前minutes分钟的 Timestamp
    *
    * @param srcTime
    * @param minutes
    * @return
    */
  def getBeforTimestamp(srcTime: String, minutes: Int): String = {
    val dateTime = parseDateTime(srcTime)
    val dateTimeR = dateTime.minusMinutes(minutes)
    dateTimeR.toString("yyyy-MM-dd HH:mm:ss")
  }


}
