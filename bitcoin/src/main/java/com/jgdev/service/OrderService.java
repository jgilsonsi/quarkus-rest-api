package com.jgdev.service;

import com.jgdev.model.Order;
import com.jgdev.model.User;
import com.jgdev.repository.OrderRepository;
import com.jgdev.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.jgdev.enums.OrderStatus.SENT;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject
    UserRepository userRepository;

    public void create(SecurityContext context, Order order) {
        Optional<User> optUser = userRepository.findByIdOptional(order.getUserId());
        User user = optUser.orElseThrow();
        if (!user.getUsername().equals(context.getUserPrincipal().getName())) {
            throw new RuntimeException("This user is not allowed to perform this transaction");
        }
        order.setDate(LocalDateTime.now());
        order.setStatus(SENT.name());
        orderRepository.persist(order);
    }

    public List<Order> getAll() {
        return orderRepository.listAll();
    }
}
