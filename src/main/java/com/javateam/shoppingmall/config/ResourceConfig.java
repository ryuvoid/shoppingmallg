package com.javateam.shoppingmall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
		
		registry.addResourceHandler("/bootstrap/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/");
		
		// axios
		registry.addResourceHandler("/axios/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/axios/");
		
		// bootstrap icons
		registry.addResourceHandler("/bootstrap-icons/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap-icons/");
		
		registry.addResourceHandler("/product_image/**")
				.addResourceLocations("file:///C:/downloads/product_images/");
	} //	
	
}
