package com.zakat.bank_app_payments.dto;


import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * DTO for {@link com.zakat.bank_app_payments.model.PaymentCategory}
 */
public record CreatePaymentCategoryRequest(
        String name,
        String icon,
        @Nullable
        Long parentCategoryId
) implements Serializable {
}