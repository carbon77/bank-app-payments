package com.zakat.bank_app_payments.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "payment_categories", schema = "bank-app-payments")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentCategory {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    private String icon;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private PaymentCategory parentCategory;


}
