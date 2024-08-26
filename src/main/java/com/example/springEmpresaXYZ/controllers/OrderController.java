package com.example.springEmpresaXYZ.controllers;

import com.example.springEmpresaXYZ.dtos.OrderRecordDto;
import com.example.springEmpresaXYZ.models.OrderModel;
import com.example.springEmpresaXYZ.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderReposutory;

    @GetMapping()
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        List<OrderModel> productsList = orderReposutory.findAll();
        if(!productsList.isEmpty()) {
            for(OrderModel product : productsList) {
                UUID id = product.getIdOrder();
                product.add(linkTo(methodOn(OrderController.class).getOneOrder(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneOrder(@PathVariable(value="id") UUID id){
        Optional<OrderModel> productO = orderReposutory.findById(id);
        if(productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        productO.get().add(linkTo(methodOn(OrderController.class).getAllOrders()).withRel("Orders List"));
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PostMapping()
    public ResponseEntity<OrderModel> saveOrder(@RequestBody @Valid OrderRecordDto productRecordDto) {
        var orderModel = new OrderModel();
        BeanUtils.copyProperties(productRecordDto, orderModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderReposutory.save(orderModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable(value="id") UUID id) {
        Optional<OrderModel> order0 = orderReposutory.findById(id);
        if(order0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        orderReposutory.delete(order0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid OrderRecordDto orderRecordDto) {
        Optional<OrderModel> orderO = orderReposutory.findById(id);
        if(orderO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        var orderModel = orderO.get();
        BeanUtils.copyProperties(orderRecordDto, orderModel);
        return ResponseEntity.status(HttpStatus.OK).body(orderReposutory.save(orderModel));
    }

}