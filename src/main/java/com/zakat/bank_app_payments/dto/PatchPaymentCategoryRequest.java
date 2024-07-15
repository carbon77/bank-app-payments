package com.zakat.bank_app_payments.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.zakat.bank_app_payments.model.PaymentCategory}
 */
public record PatchPaymentCategoryRequest(String name, String icon, Long parentCategoryId) implements Serializable {
}