package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}
// findByUserId(Long userId) : will help fetch all orders belonging to a specific user.

/*
How does findByUserId() work?

You don't have a field called userId in Order.
You have:
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

and inside User:
private Long id;
Spring Data JPA understands nested properties.
So:
findByUserId(Long userId)
is interpreted as:
Order.user.id
which translates roughly to:

SELECT *
FROM orders
WHERE user_id = ?
*/