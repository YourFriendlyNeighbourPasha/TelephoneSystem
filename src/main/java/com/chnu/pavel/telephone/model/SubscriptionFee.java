package com.chnu.pavel.telephone.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.SubscriptionFee
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 10.03.2021|11:33
 * @Version SubscriptionFee: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "subscriptionFees")
public class SubscriptionFee {

    @Id
    private String       id;
    private BigDecimal   localCallsCost;
    private BigDecimal   intercityCallsCost;

}
