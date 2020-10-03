package com.chen.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

/**
 * 描述：测试 PostProcessorRegistrationDelegate 处理 regularPostProcessors 流程
 *
 * 测试结果：
 * 如果自定义类实现了 BeanFactoryPostProcessor 或 BeanDefinitionRegistryPostProcessor，且自定义类没有添加@Component注解，
 * 而是通过 context.addBeanFactoryPostProcessor(new TestRegularPostProcessor()) 添加的，
 * 则会将此类添加到 PostProcessorRegistrationDelegate#regularPostProcessors 数组中，
 * 在所有的 BeanDefinitionRegistryPostProcessor 执行完成之后（内置的、自定义的、实现 Ordered 接口的），才会执行此类
 *
 * @author chen
 */
public class TestRegularPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("beanFactory = " + Arrays.toString(beanFactory.getBeanDefinitionNames()));
	}
}
