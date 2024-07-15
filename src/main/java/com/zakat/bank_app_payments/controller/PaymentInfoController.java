package com.zakat.bank_app_payments.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments/infos")
@SecurityRequirement(name = "Authorization")
@Tag(name = "Информация о платежах")
@CrossOrigin("*")
public class PaymentInfoController {

    @GetMapping
    public String getPaymentInfo() {
        return "Payment Info";
    }

    @PostMapping
    public String createPaymentInfo() {
        return "Payment Info Created";
    }
}
