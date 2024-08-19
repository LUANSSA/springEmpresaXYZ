package com.example.springEmpresaXYZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springEmpresaXYZ.models.OrderModel;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, UUID>{

}
