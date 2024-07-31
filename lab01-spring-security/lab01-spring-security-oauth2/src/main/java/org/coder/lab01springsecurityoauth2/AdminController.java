package org.coder.lab01springsecurityoauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author dongnan
 * @CreateTime 2024/07/25  16:55
 */
@RestController
public class AdminController {

    @GetMapping(value = "/demo")
    public String demo() {
        return "demo";
    }
}
