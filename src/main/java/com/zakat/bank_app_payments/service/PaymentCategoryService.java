package com.zakat.bank_app_payments.service;

import com.zakat.bank_app_payments.dto.CreatePaymentCategoryRequest;
import com.zakat.bank_app_payments.dto.PatchPaymentCategoryRequest;
import com.zakat.bank_app_payments.dto.PaymentCategoryDto;
import com.zakat.bank_app_payments.dto.mapper.PaymentCategoryMapper;
import com.zakat.bank_app_payments.model.PaymentCategory;
import com.zakat.bank_app_payments.repository.PaymentCategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentCategoryService {

    private final PaymentCategoryRepository paymentCategoryRepository;
    private final PaymentCategoryMapper paymentCategoryMapper;

    public PaymentCategoryService(PaymentCategoryRepository paymentCategoryRepository,
                                  PaymentCategoryMapper paymentCategoryMapper) {
        this.paymentCategoryRepository = paymentCategoryRepository;
        this.paymentCategoryMapper = paymentCategoryMapper;
    }

    @Transactional
    public List<PaymentCategoryDto> findAll() {
        return paymentCategoryRepository.findAll().stream()
                .map(paymentCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PaymentCategoryDto create(CreatePaymentCategoryRequest request) {
        var paymentCategory = PaymentCategory.builder()
                .name(request.name())
                .icon(request.icon())
                .parentCategory(request.parentCategoryId() == null ? null : findById(request.parentCategoryId()))
                .updatedAt(Date.from(Instant.now()))
                .createdAt(Date.from(Instant.now()))
                .build();

        paymentCategoryRepository.save(paymentCategory);
        return paymentCategoryMapper.toDto(paymentCategory);
    }

    @Transactional(readOnly = true)
    public PaymentCategoryDto findDtoById(Long id) {
        return paymentCategoryMapper.toDto(findById(id));
    }

    @Transactional(readOnly = true)
    public PaymentCategory findById(Long id) {
        return paymentCategoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment category not found"));
    }

    @Transactional
    public void patch(Long id, PatchPaymentCategoryRequest request) {
        var paymentCategory = findById(id);

        if (request.name() != null) {
            paymentCategory.setName(request.name());
        }

        if (request.icon() != null) {
            paymentCategory.setIcon(request.icon());
        }

        if (request.parentCategoryId() != null) {
            paymentCategory.setParentCategory(findById(request.parentCategoryId()));
        }
    }

    @Transactional
    public void delete(Long id) {
        var paymentCategory = findById(id);
        paymentCategoryRepository.delete(paymentCategory);
    }
}
