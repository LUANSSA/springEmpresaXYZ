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
public class OrderController {

    @Autowired
    OrderRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        List<OrderModel> productsList = productRepository.findAll();
        if(!productsList.isEmpty()) {
            for(OrderModel product : productsList) {
                UUID id = product.getIdOrder();
                product.add(linkTo(methodOn(OrderController.class).getOneOrder(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneOrder(@PathVariable(value="id") UUID id){
        Optional<OrderModel> productO = productRepository.findById(id);
        if(productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        productO.get().add(linkTo(methodOn(OrderController.class).getAllOrders()).withRel("Orders List"));
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PostMapping("/products")
    public ResponseEntity<OrderModel> saveOrder(@RequestBody @Valid OrderRecordDto productRecordDto) {
        var productModel = new OrderModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable(value="id") UUID id) {
        Optional<OrderModel> productO = productRepository.findById(id);
        if(productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully.");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid OrderRecordDto productRecordDto) {
        Optional<OrderModel> productO = productRepository.findById(id);
        if(productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        var productModel = productO.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

}