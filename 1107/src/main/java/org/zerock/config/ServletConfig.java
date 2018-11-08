package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"org.zerock.controller"})
public class ServletConfig implements WebMvcConfigurer{
	
	@Bean
	public MultipartResolver multipartResolver() throws Exception{
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		resolver.setMaxUploadSize(1024 * 1024 * 10);
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
		resolver.setMaxInMemorySize(1024 * 1024);
		resolver.setUploadTempDir(new FileSystemResource("C:\\upload\\tmp"));
		resolver.setDefaultEncoding("UTF-8"); //¾È³ÖÀ¸¸é ÇÑ±Û ±úÁü
		
		return resolver;
	}
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver =
				new InternalResourceViewResolver("WEB-INF/views/", ".jsp");
		
		resolver.setViewClass(JstlView.class);
		
		registry.viewResolver(resolver);
	}
	

}
