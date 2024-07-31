package org.coder.lab02authorizationserverpasswordcredentials.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/26  16:17
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Value("${security.oauth2.access-token-uri}")
    private String accessTokenUri;
    @Resource
    private OAuth2ClientProperties oauth2ClientProperties;
    @PostMapping("/login")
    public OAuth2AccessToken login(@RequestParam("username") String username,
                                   @RequestParam("password") String password)
    {
        //1、创建ResourceOwnerPasswordResourceDetails对象,填写密码模式需要的参数
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setAccessTokenUri(accessTokenUri);
        resourceDetails.setClientId(oauth2ClientProperties.getClientId());
        resourceDetails.setClientSecret(oauth2ClientProperties.getClientSecret());
        resourceDetails.setUsername(username);
        resourceDetails.setPassword(password);
        //2、创建Oauth2RestTemplate对象，用于请求授权服务器
        OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(resourceDetails);
        // 使用密码模式授权
        oauth2RestTemplate.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider());
        //3、获取访问令牌
        return oauth2RestTemplate.getAccessToken();
    }
}
