package org.coder.lab0201springresourceserver.demos.web;

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

    @GetMapping("/test01")
    @PreAuthorize("hasAuthority('SCOPE_message.read')")
    public String test(){
        return "test01";
    }

    @GetMapping("/test02")
    @PreAuthorize("hasAuthority('SCOPE_message.write')")
    public String test02() {
        return "test02";
    }
    @GetMapping("/app")
    @PreAuthorize("hasAuthority('app')")
    public String app(){
        return "app";
    }
}
