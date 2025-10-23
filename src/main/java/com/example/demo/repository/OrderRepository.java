package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}
