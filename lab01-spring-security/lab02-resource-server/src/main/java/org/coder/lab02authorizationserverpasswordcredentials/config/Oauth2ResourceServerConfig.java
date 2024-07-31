package org.coder.lab02authorizationserverpasswordcredentials.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/26  09:50
 */
@Configuration
@EnableResourceServer //声明开启资源服务器的功能
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 登录接口放行
                .antMatchers("/auth/login","/callback","/callback2").permitAll()
                // 其他接口需要认证
                .anyRequest().authenticated();
    }
}
