package org.coder.lab02authorizationserverpasswordcredentials.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/26  09:53
 */
@RestController
@RequestMapping("/api")
public class ExampleController {

    @RequestMapping("/demo")
    public String demo()
    {
        return "demo";
    }
}
