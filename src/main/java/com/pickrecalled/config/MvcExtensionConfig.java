package com.pickrecalled.config;

import com.pickrecalled.component.ExtensionLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcExtensionConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/*").setViewName("login");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new ExtensionLocaleResolver();
	}
}
