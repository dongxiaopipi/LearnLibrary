package org.coder.lab02authorizationserverpasswordcredentials.controller;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/30  16:15
 */
@RestController
public class TokenController {

    @Resource
    private ConsumerTokenServices tokenServices;


    @PostMapping("/revoke")
    public boolean revokeToken(@RequestParam("token") String token) {
        return tokenServices.revokeToken(token);
    }
}
