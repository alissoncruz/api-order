package com.api.store.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="order")
@Table(name="order")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private Double price;

    private Double quantity;
}
