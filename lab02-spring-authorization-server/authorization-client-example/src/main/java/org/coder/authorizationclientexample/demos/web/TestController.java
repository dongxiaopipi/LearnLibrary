package org.coder.authorizationclientexample.demos.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/09/19  14:45
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('SCOPE_message.read')")
    public String test(){
        return "hello world";
    }

    @GetMapping("/app")
    @PreAuthorize("hasAuthority('app')")
    public String app(){
        return "app";
    }
}
