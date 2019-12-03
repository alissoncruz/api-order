package com.api.store.order.controller;



import com.api.store.api.OrderApi;
import com.api.store.model.NewOrderTO;
import com.api.store.model.OrderCodeTO;
import com.api.store.model.OrderTO;
import com.api.store.model.UpdateOrderTO;
import com.api.store.order.entity.OrderEntity;
import com.api.store.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.api.store.order.utils.ParserUtil.convertValue;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class OrderController extends BaseController implements OrderApi {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<OrderCodeTO> createOrder(@Valid NewOrderTO newOrder) {
        System.out.println("Create store");
        OrderEntity orderEntity = convertValue(newOrder, OrderEntity.class);
        OrderEntity entity = orderService.createStore(orderEntity);
        OrderCodeTO response = convertValue(entity, OrderCodeTO.class);
        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<OrderTO> getOrder(Long id) {
        System.out.println("Get store");
        OrderEntity entity = orderService.getStore(id);
        OrderTO response = convertValue(entity, OrderTO.class);
        return  new ResponseEntity<>(response, OK);
    }

    @Override
    public ResponseEntity<Void> updateOrder(Long id, @Valid UpdateOrderTO order) {
        orderService.updateStore(id, convertValue(order, OrderEntity.class));
        System.out.println("Update store");
        return new ResponseEntity<>(OK);
    }


}
