package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class HystrixController {

    @GetMapping("/account")
    public String accountFallback() {
        return "Account Service is not available.";
    }

    @GetMapping("/product")
    public String ticketFallback() {
        return "Product Service is not available.";
    }
}
