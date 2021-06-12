package vn.PTIT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration 
@EnableWebMvc 
@ComponentScan(basePackages = { "vn.PTIT" }) 
public class WebMVC implements WebMvcConfigurer {
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("------------ MVC -------------");
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/META-INF/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/META-INF/img/");
		registry.addResourceHandler("/favicons/**").addResourceLocations("classpath:/META-INF/favicons/");
		registry.addResourceHandler("/files_posterVideo/**").addResourceLocations("file:D:/Devpro/JavaWeb07/Homeworks/MovieProject/upload/Poster_Video/");
		registry.addResourceHandler("/files_banner/**").addResourceLocations("file:D:/Devpro/JavaWeb07/Homeworks/MovieProject/upload/Banner/");
	}

}
