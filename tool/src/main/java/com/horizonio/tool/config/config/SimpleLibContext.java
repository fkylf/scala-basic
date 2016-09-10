package com.horizonio.tool.config.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.Serializable;

/**
 * Created by zqh  on 2016/9/5
 */
public class SimpleLibContext implements Serializable {

    private Config config;

    //指定配置文件
    public SimpleLibContext(Config config) {
        this.config = config;
//        config.checkValid(ConfigFactory.defaultReference(), "simple-lib");
    }

    // 默认加载classpath下的application.*
    public SimpleLibContext() {
        this(ConfigFactory.load());
    }

    //打印
    public void printSetting(String path) {
        System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }

    public String getSetting(String path) {
        if (config.getString(path) == null || config.getString(path).trim().isEmpty()) {
            throw new RuntimeException(path + " is null or empty");
        }
        return config.getString(path);
    }

    public boolean getSettingBoolean(String path) {
        return config.getBoolean(path);
    }

//    public Map<String,String> getConfMap(){
//        Map<String,String> map=new HashMap<String, String>() ;
//
//        return  map;
//    }

    public static void main(String[] args) {
        SimpleLibContext s = new SimpleLibContext();
        s.printSetting("mysqlDB.user");
        s.printSetting("postgresDB.url");
    }
}
