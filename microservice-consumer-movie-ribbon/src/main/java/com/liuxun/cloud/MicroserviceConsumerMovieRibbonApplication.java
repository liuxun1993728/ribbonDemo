package com.liuxun.cloud;

import com.liuxun.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient

// 自定义RibbonClient配置方式一：通用方式: 在springboot能扫描包的范围之外(实际上只要不与主程序在同一级目录)定义RibbonClient的配置类，然后引入配置
// @RibbonClient(name = "microservice-provider-user",configuration = TestConfiguration.class)

// 自定义RibbonClient配置方式二：在springboot主程序同级目录自定义RibbonClient的配置类，并添加自定义注解进行标识,然后根据注解标识排除扫描
@RibbonClient(name = "microservice-provider-user",configuration = TestConfiguration1.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
public class MicroserviceConsumerMovieRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
