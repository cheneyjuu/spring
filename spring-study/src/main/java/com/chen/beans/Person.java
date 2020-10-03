package com.chen.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

/**
 * @author chen
 */
@Repository
public class Person implements ApplicationContextAware {
	private ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		System.out.println("applicationContext = " + applicationContext);
	}
}
