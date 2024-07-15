package com.zakat.bank_app_payments.repository;

import com.zakat.bank_app_payments.model.PaymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCategoryRepository extends JpaRepository<PaymentCategory, Long> {
}