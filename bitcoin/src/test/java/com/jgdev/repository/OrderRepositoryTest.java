package com.jgdev.repository;

import com.jgdev.model.Order;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class OrderRepositoryTest {

    @InjectMock
    OrderRepository orderRepository;

    @Test
    public void listAllTest() {
        Order order1 = new Order();
        Order order2 = new Order();

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Mockito.when(orderRepository.listAll()).thenReturn(orderList);

        Assertions.assertSame(order2, orderRepository.listAll().get(1));
    }
}
