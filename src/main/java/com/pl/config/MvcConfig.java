package com.pl.config;
import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages = {"com.pl.web"})
@EnableWebMvc
//@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:application.properties")
public class MvcConfig {
	
 
    @Resource
    private Environment environment;
}
