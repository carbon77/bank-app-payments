package com.zakat.bank_app_payments.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_fields")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentField {

    @Id
    @Column(name = "payment_field_id")
    private Long id;

    @Column(name = "field_name")
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "payment_info_id")
    private PaymentInfo paymentInfo;

    @Column(name = "field_type")
    @Enumerated(EnumType.STRING)
    private FieldType type;

    private boolean required;
    private boolean hidden;
    private boolean readOnly;
    private Integer fieldOrder;
}
