package com.horizonio.swamp.spark;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

/**
 * Created by zqh  on 2016/7/27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("hello world Test1");



        DateTimeFormatter dateTimeFormater = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai")));
        if(dateTimeFormater.parseDateTime("2016-08-17 10:00:00").isBefore(dateTimeFormater.parseDateTime("2016-08-17 10:00:01").withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai"))))){
            System.out.println("2016-08-17 10:00:00 < 2016-08-17 13:00:00");
        }
    }
}
