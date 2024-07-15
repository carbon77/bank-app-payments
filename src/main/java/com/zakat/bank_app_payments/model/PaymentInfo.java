package com.zakat.bank_app_payments.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_infos")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentInfo {

    @Id
    @Column(name = "payment_info_id")
    private UUID id;

    private Double minAmount;
    private Date createdAt;
    private Date updatedAt;
    private boolean published;
}
