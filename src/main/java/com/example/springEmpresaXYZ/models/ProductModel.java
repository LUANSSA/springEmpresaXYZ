package com.example.springEmpresaXYZ.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;


import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "tb_001_product")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idProduct;
	private String name;
	private BigDecimal value;
	private String description;

	public UUID getIdProduct() { return idProduct; }

	public void setIdProduct(UUID idProduct) { this.idProduct = idProduct; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public BigDecimal getValue() { return value; }

	public void setValue(BigDecimal value) { this.value = value; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }
}
