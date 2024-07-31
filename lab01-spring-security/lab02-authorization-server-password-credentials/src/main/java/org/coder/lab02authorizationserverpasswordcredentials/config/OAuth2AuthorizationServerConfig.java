package org.coder.lab02authorizationserverpasswordcredentials.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * 1、添加 @EnableAuthorizationServer 注解，声明开启 OAuth 授权服务器的功能
 * 2、继承 AuthorizationServerConfigurerAdapter 类，并重写其方法
 * 3、# configure(AuthorizationServerEndpointsConfigurer security)，配置AuthenticationManager实现用户认证功能
 * 4、# configure(AuthorizationServerSecurityConfigurer security)，设置/oauth/check_token 端点，通过认证后可访问，
 *      其中，/oauth/check_token 端点对应  CheckTokenEndpoint 类，用于校验访问令牌的有效性。
 *      在客户端访问资源服务器时，会在请求中带上访问令牌。
 *      在资源服务器收到客户端的请求时，会使用请求中的访问令牌，找授权服务器确认该访问令牌的有效性。
 * @Author dongnan
 * @CreateTime 2024/07/25  17:17
 */
@Configuration
@EnableAuthorizationServer //声明开启 OAuth 授权服务器的功能
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 用户认证管理器
     */
    @Resource
    private AuthenticationManager authenticationManager;
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }

    /**
     * 客户端配置（基于内存）
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientapp")
                .secret("123")
                .authorizedGrantTypes("password")
                .scopes("read_userinfo", "read_contacts");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
