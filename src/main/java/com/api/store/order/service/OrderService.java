package com.api.store.order.service;

import com.api.store.order.entity.OrderEntity;

public interface OrderService {

    OrderEntity createStore(OrderEntity orderEntity);

    OrderEntity getStore(Long id);

    OrderEntity updateStore(Long id, OrderEntity entity);

}
