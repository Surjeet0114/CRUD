package com.example.demo.entity;

import com.example.demo.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String productName;
    //private Integer quantity;
    //private Double price;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public Order() {
    }

    public Order(//Long id,
                 //String productName,
                 //Integer quantity,
                 //Double price,
                 LocalDateTime orderDate,
                 OrderStatus status,
                 User user) {

        //this.id = id;
        //this.productName = productName;
        //this.quantity = quantity;
        //this.price = price;
        this.orderDate = orderDate;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //For setting the relation with the table user
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    public void prePersist() {
        orderDate = LocalDateTime.now();
    }
}
/*
Without setters, code like this won't compile:

Order order = new Order();

order.setProductName(dto.getProductName());
order.setPrice(dto.getPrice());
order.setUser(user);

because those methods won't exist.
*/


/*
    Why do we create a no-args constructor?
    public Order() {}

    Because JPA/Hibernate requires it.
    When Hibernate fetches data from the database, it creates objects like this:
    Order order = new Order();
    Then it fills the fields internally.
    If there is no no-args constructor, Hibernate cannot instantiate the entity properly.
    That's why every JPA entity should have a no-argument constructor.

    Why do we create a parameterized constructor?
    It's just a convenience for developers.


    Why is User user included in the constructor?

     Because your Order entity contains:
     @ManyToOne
     @JoinColumn(name = "user_id")
     private User user;
     The user field is part of the entity, just like:

     private String productName;
     private Double price;

     So if you create a constructor that initializes all fields, you should include user too.
*/