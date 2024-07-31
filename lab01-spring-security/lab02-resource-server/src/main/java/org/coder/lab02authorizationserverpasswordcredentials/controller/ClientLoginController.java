package org.coder.lab02authorizationserverpasswordcredentials.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/30  14:59
 */
@RestController
@RequestMapping(value ="/")
public class ClientLoginController {


    @Value("${security.oauth2.access-token-uri}")
    private String accessTokenUri;
    @Resource
    private OAuth2ClientProperties oauth2ClientProperties;

    @PostMapping("/client-login")
    public OAuth2AccessToken login() {
        //创建ClientCredientailsResourceDetails对象
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId(oauth2ClientProperties.getClientId());
        resourceDetails.setClientSecret(oauth2ClientProperties.getClientSecret());
        resourceDetails.setAccessTokenUri(accessTokenUri);
        //创建Oauth2RestTemplate
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails);
        oAuth2RestTemplate.setAccessTokenProvider(new ClientCredentialsAccessTokenProvider());

        return oAuth2RestTemplate.getAccessToken();

    }

}
