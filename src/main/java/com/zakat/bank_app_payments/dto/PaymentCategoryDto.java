package com.zakat.bank_app_payments.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.zakat.bank_app_payments.model.PaymentCategory}
 */
public record PaymentCategoryDto(Long id, String name, String icon, Date createdAt, Date updatedAt, ParentPaymentCategoryDto parentCategory) implements Serializable {
    /**
     * DTO for {@link com.zakat.bank_app_payments.model.PaymentCategory}
     */
    public record ParentPaymentCategoryDto(Long id, String name, String icon) implements Serializable {
    }
}