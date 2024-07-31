package org.coder.lab02authorizationserverpasswordcredentials.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/29  17:14
 */
@RestController
@RequestMapping("/")
public class CallbackController {

    @Value("${security.oauth2.access-token-uri}")
    private String accessTokenUri;
    @Resource
    private OAuth2ClientProperties oauth2ClientProperties;

    @GetMapping("/callback")
    public OAuth2AccessToken callback(@RequestParam(value = "code", required = true) String code) {
        //1、创建ResourceOwnerPasswordResourceDetails对象,填写密码模式需要的参数
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setAccessTokenUri(accessTokenUri);
        resourceDetails.setClientId(oauth2ClientProperties.getClientId());
        resourceDetails.setClientSecret(oauth2ClientProperties.getClientSecret());
        //2、创建Oauth2RestTemplate对象，用于请求授权服务器
        OAuth2RestTemplate oauth2RestTemplate = new OAuth2RestTemplate(resourceDetails);
        oauth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().setAuthorizationCode(code);
        oauth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().setPreservedState("http://127.0.0.1:9090/callback");
        // 使用授权码模式授权
        oauth2RestTemplate.setAccessTokenProvider(new AuthorizationCodeAccessTokenProvider());
        //3、获取访问令牌
        return oauth2RestTemplate.getAccessToken();
    }

    @GetMapping("/callback2")
    public String callback2()
    {
        return "callback2";
    }

}
