
package com.api.store.order.entity;

import com.api.store.order.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="order")
@Table(name="order")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Address address;

    @Builder.Default
    private Date confirmationDate = new Date();

    @Builder.Default
    private StatusEnums status = StatusEnums.INITIATED;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItems> orderItems = new ArrayList<>();
}
