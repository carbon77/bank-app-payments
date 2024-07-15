package com.zakat.bank_app_payments.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_field_choices")
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentFieldChoice {

    @Id
    @Column(name = "payment_field_choice_id")
    private Long id;

    @Column(name = "choice_text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "payment_field_id")
    private PaymentField paymentField;
}
