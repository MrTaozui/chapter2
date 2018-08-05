package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tjj .
 */
public final class PropsUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);
    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties props=null;
        InputStream is=null;
        try {
        //使用相对于当前项目的classpath的相对路径来查找资源  三种类加载器
        //main/java main/resource test/java test/resources	都是classpath 目录
        // 当运行单元测试的时候 就近原则 就即先从 test/java ,test/resources加载类或读取文件       	
        is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if(is==null){
            throw new FileNotFoundException(fileName+"file is not found");
        }
        props=new Properties();
        props.load(is);
        }catch (IOException e){
        LOGGER.error("load properties file failure",e);
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                   LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }
    /**
     * 获取字符型属性 默认值为空字符串
     */
    public static  String getString(Properties props,String key){
        return getString(props,key,"");
    }
    /**
     * 获取字符型属性 可指定默认值
     */
    public static String getString(Properties props,String key,String defaultValue){
        String value=defaultValue;
        if(props.containsKey(key)){
            value=props.getProperty(key);
        }
        return value;
    }
    /**
     * 获取数值型属性 默认值为0
     */
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }
    /**
     * 获取数值型属性
     */
    public static int getInt(Properties props,String key,int defaultValue){
        int value=defaultValue;
        if(props.containsKey(key)){
            value= CastUtil.castInt(props.get(key));
        }
        return value;
    }
    /***
     * 获取布尔型值
     */
    public static boolean getBoolean(Properties props,String key){
        return  getBoolean(props,key,false);
    }
    /***
     * 获取布尔型值 指定默认值
     * 如果不存在 就返回默认值
     */
    public static boolean getBoolean(Properties props,String key,boolean defaultBooleanValue){
        boolean booleanValue=defaultBooleanValue;
        if(props.containsKey(key)){
            booleanValue=CastUtil.castBoolean(props.getProperty(key));
        }
        return  booleanValue;
    }
}
