package com.example.demo.dao;

import com.example.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsDAO extends JpaRepository<Shop, Long> {
}
