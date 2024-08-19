package com.example.springEmpresaXYZ.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "tb_001_order")
public class OrderModel extends RepresentationModel<OrderModel> implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idOrder;
    @NotNull

    public UUID getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(UUID idOrder) {
        this.idOrder = idOrder;
    }



}
