package com.rca.mireilleumutoni.template.v1.models;

import com.rca.mireilleumutoni.template.v1.enums.ETokenStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PurchaseToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meter_number", length = 6, nullable = false)
    private String meterNumber;

    @Column(name = "token", length = 8, nullable = false)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_status", nullable = false)
    private ETokenStatus tokenStatus;

    @Column(name = "token_value_days", nullable = false)
    private Integer tokenValueDays;

    @Column(name = "purchased_date", nullable = false)
    private LocalDateTime purchasedDate;

    @Column(name = "amount", nullable = false)
    private Integer amount;


    // Getters and setters
}