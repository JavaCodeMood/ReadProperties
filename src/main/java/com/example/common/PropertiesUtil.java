package com.example.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @ClassName PropertiesUtil
 * @Description 更新配置文件值
 */
public class PropertiesUtil {
	private static Logger logger=Logger.getLogger(PropertiesUtil.class);
	public static void replaceProperty(String conFile,String key,String value){
		Properties properties=new Properties();
		InputStream input = null;
		OutputStream output =null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            input = classLoader.getResourceAsStream(conFile);
            String path = PropertiesUtil.class.getClassLoader().getResource(conFile).getPath();
            output = new FileOutputStream(path);
            properties.load(input);
            String servers=(String) properties.get("bootstrap.servers");
            System.out.println(servers);
            input.close();
            properties.setProperty(key, value);
            String servers1=(String) properties.get("bootstrap.servers");
            System.out.println(servers1);
            properties.store(output, "replace bootstrap.servers property");
            output.close();
		} catch (IOException e) {
			logger.info("请检查"+conFile+"文件是否存在！");
			e.printStackTrace();
		}
			
			
	}
	public static void main(String[] args) {
		PropertiesUtil.replaceProperty("kafka.consumer.properties", "bootstrap.servers", "123");
	}
}
