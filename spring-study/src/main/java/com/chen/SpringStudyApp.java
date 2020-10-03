package com.chen;

import com.chen.beans.TestRegularPostProcessor;
import com.chen.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author chen
 */
public class SpringStudyApp {
	public static void main(String[] args) {
		/*
		this()方法:

			0. AnnotationConfigApplicationContext 继承自 GenericApplicationContext，GenericApplicationContext默认构造会实例化DefaultListableBeanFactory;
			1. AnnotationConfigApplicationContext默认构造实例化了AnnotatedBeanDefinitionReader,
				在此过程中，调用了AnnotationConfigUtils#registerAnnotationConfigProcessors方法，这个方法的主要作用：
				1.1. 往DefaultListableBeanFactory的beanDefinitionMap中put了spring内置的postProcessors，比如：org.springframework.context.annotation.internalConfigurationAnnotationProcessor；
				1.2. 把spring内置的postProcessors的beanName添加到DefaultListableBeanFactory的beanDefinitionNames[]中
			2. AnnotationConfigApplicationContext默认构造实例化了ClassPathBeanDefinitionScanner,主要作用
				2.1. 提前往includeFilters里面添加需要扫描的特定注解；
				2.2. 添加元注解@Component，需要注意的是@Repository、@Service、@Controller里面都标注了@Component。很好理解，扫描的时候用includeFilters 去过滤时，会找到并处理这4个注解的类。
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		/*
		register(Class<?>... componentClasses)方法：

			解析传入的类，并添加到DefaultListableBeanFactory的beanDefinitionMap和beanDefinitionNames中
		 */
		context.register(AppConfig.class);
		context.addBeanFactoryPostProcessor(new TestRegularPostProcessor());
		context.refresh();
		System.out.println("context.getBean(\"user\") = " + context.getBean("user"));
	}
}
