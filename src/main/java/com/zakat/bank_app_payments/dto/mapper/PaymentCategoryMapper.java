package com.zakat.bank_app_payments.dto.mapper;

import com.zakat.bank_app_payments.dto.PaymentCategoryDto;
import com.zakat.bank_app_payments.model.PaymentCategory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentCategoryMapper {
    PaymentCategory toEntity(PaymentCategoryDto paymentCategoryDto);

    PaymentCategoryDto toDto(PaymentCategory paymentCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaymentCategory partialUpdate(PaymentCategoryDto paymentCategoryDto, @MappingTarget PaymentCategory paymentCategory);
}