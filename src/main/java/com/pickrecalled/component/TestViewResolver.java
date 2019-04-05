package com.pickrecalled.component;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@Configuration
public class TestViewResolver {

	@Bean
	public ViewResolver myViewResolver() {
		// 返回定义视图解析器
		return new MyViewResolver();
	}

	/**
	 * 内部内的方式自定义视图解析器
	 */
	private static class MyViewResolver implements ViewResolver {

		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			// 为了演示这里就不实现业务了
			return null;
		}
	}

}
