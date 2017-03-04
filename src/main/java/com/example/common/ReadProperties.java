package com.example.common;

import java.util.Properties;

/**
 * SpringBoot实现读取application.properties属性文件内容。
 * @author dell
 *
 */
public class ReadProperties {
	
	public static void read(){
		try {
			//创建properties对象
			Properties properties = new Properties();
			//加载属性配置文件
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"));
			//读取属性文件中的内容
			//1.先读取联系人号码
			String contact = properties.getProperty("contact");
			String[] people = contact.split(",");
			for(int i=0;i<people.length;i++){
				//System.out.println("联系人"+i+":"+people[i]);
				String[] name_phone = people[i].split(":");
				for(int j=0;j<name_phone.length;j++){
					System.out.print(name_phone[j] + ",");
				}
				String name = name_phone[0];
				String phone = name_phone[1];
				
				System.out.println("\n姓名："+name + ",电话号码："+phone);
			}
			System.out.println();
			
			
			//2.读取联系人居住地址
			String contactAddress = properties.getProperty("address");
			String[] str = contactAddress.split(",");
			for(int x=0;x<str.length;x++){
				//System.out.println("联系人居住地："+ x + ":" +str[x]);
				String[] nation = str[x].split(":");
				for(int y=0;y<nation.length;y++){
					System.out.print(nation[y]+"-");
				}
				String Place_names = nation[1]; 
			}
			System.out.println("\n");
			
			
			
			//3.读取联系人性别
			String contactSex = properties.getProperty("sex");
			String[] sex = contactSex.split(" ");
			for(int k=0;k<sex.length;k++){
				System.out.println("联系人性别："+sex[k]);
			}
			
			//4.联系人是否是地球人
			String flag = properties.getProperty("flag");
			System.out.println("联系人"+flag+"地球人！");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}

	public static void main(String[] args) {
		read();
	}

}
