package com.chen;

import com.chen.beans.TestRegularPostProcessor;
import com.chen.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chen
 */
public class SpringStudyApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.addBeanFactoryPostProcessor(new TestRegularPostProcessor());
		context.refresh();
		System.out.println("context.getBean(\"user\") = " + context.getBean("user"));
	}
}
