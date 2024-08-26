package com.example.springEmpresaXYZ.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "tb_001_order")
public class OrderModel extends RepresentationModel<OrderModel> implements Serializable{
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idOrder;
    // Status do pedido, anotado com @NotNull para garantir que não seja nulo.
    @NotNull
    private String orderStatus;
    // Data de registro do pedido, anotado com @NotNull para garantir que não seja nula.
    @NotNull
    private Date registrationDate;

    // Retorna o identificador único do pedido.
    public UUID getIdOrder() { return idOrder; }

    // Define o identificador único do pedido.
    public void setIdOrder(UUID idOrder) { this.idOrder = idOrder; }

    // Retorna o status do pedido.
    public @NotNull String getOrderStatus() { return orderStatus; }

    // Define o status do pedido.
    public void setOrderStatus(@NotNull String orderStatus) { this.orderStatus = orderStatus; }

    // Retorna a data de registro do pedido.
    public @NotNull Date getRegistrationDate() { return registrationDate; }

    // Define a data de registro do pedido.
    public void setRegistrationDate(@NotNull Date registrationDate) { this.registrationDate = registrationDate; }


}
