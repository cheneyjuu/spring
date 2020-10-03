package com.chen.config;

import com.chen.beans.TestRegularPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 */
@Configuration
@ComponentScan("com.chen")
public class AppConfig {

	@Bean
	public TestRegularPostProcessor order() {
		return new TestRegularPostProcessor();
	}

	@Configuration
	class InnerConfig {

	}
}
