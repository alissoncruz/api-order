package com.api.store.order.service.impl;

import com.api.store.order.entity.Address;
import com.api.store.order.entity.OrderEntity;
import com.api.store.order.repository.OrderRepository;
import com.api.store.order.service.OrderService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity createStore(OrderEntity orderEntity) {
        OrderEntity store = orderRepository.save(orderEntity);
        return store;
    }

    @Override
    public OrderEntity getStore(Long id) {
        Optional<OrderEntity> store = orderRepository.findById(id);
        if(!store.isPresent()){
            throw new ObjectNotFoundException(id,"Store not found");
        }
        return store.get();
    }

    @Override
    public OrderEntity updateStore(Long id, OrderEntity entity) {
        OrderEntity update = getStore(id);

        Address a = Address
                .builder()
                .id(update.getAddress().getId())
                .cep(entity.getAddress().getCep())
                .street(entity.getAddress().getStreet())
                .build();
        update.setAddress(a);
        orderRepository.save(update);

        return update;
    }
}
