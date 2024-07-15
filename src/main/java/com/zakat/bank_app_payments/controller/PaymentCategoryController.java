package com.zakat.bank_app_payments.controller;

import com.zakat.bank_app_payments.dto.CreatePaymentCategoryRequest;
import com.zakat.bank_app_payments.dto.PatchPaymentCategoryRequest;
import com.zakat.bank_app_payments.dto.PaymentCategoryDto;
import com.zakat.bank_app_payments.service.PaymentCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payments/categories")
@Tag(name = "Payment Categories")
public class PaymentCategoryController {

    private final PaymentCategoryService paymentCategoryService;

    public PaymentCategoryController(PaymentCategoryService paymentCategoryService) {
        this.paymentCategoryService = paymentCategoryService;
    }

    @GetMapping
    @Operation(summary = "Get payment categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved payment categories", content = @Content(schema = @Schema(implementation = List.class))),
    })
    public List<PaymentCategoryDto> getPaymentCategory() {
        return paymentCategoryService.findAll();
    }

    @GetMapping("/{categoryId}")
    @Operation(summary = "Get payment category by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved payment category", content = @Content(schema = @Schema(implementation = PaymentCategoryDto.class))),
            @ApiResponse(responseCode = "404", description = "Payment category not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public PaymentCategoryDto getPaymentCategoryById(@PathVariable Long categoryId) {
        return paymentCategoryService.findDtoById(categoryId);
    }

    @PostMapping
    @Operation(summary = "Create new payment category")
    public PaymentCategoryDto createPaymentCategory(@RequestBody CreatePaymentCategoryRequest request) {
        return paymentCategoryService.create(request);
    }

    @PatchMapping("/{categoryId}")
    @Operation(summary = "Update payment category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Payment category updated successfully"),
            @ApiResponse(responseCode = "404", description = "Payment category not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> updatePaymentCategory(
            @PathVariable Long categoryId,
            @RequestBody PatchPaymentCategoryRequest request
    ) {
        paymentCategoryService.patch(categoryId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete payment category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Payment category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Payment category not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> deletePaymentCategory(@PathVariable Long categoryId) {
        paymentCategoryService.delete(categoryId);
        return ResponseEntity.noContent().build();
    }
}
