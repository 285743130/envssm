package com.pb.common;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {

	public static void main(String[] args) {

		BeanFactory factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//
		// factory.registerShutdownHook();
		

		//
		// System.out.println(student.getBirthday());
		// System.out.println(student.getList());
		// System.out.println(student.getMap());
		// System.out.println(student.getProps());

	}

}
