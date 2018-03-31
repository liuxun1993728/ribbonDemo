package com.liuxun.cloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration1 {
    @Autowired
    private IClientConfig config;


    @Bean
    public IRule ribbonRule(IClientConfig config) { // 自定义为随机规则
        return new RandomRule();
    }
}
