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
	
	// Identificador único do produto, do tipo UUID (Universally Unique Identifier).
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID idProduct;
	// Armazena o nome do produto.
	private String name;
	// Armazena o valor do produto, utilizando BigDecimal para lidar com valores monetários de forma precisa.
	private BigDecimal value;
	// Armazena a descrição do produto.
	private String description;

	// Retorna o identificador único do produto.
	public UUID getIdProduct() { return idProduct; }

	// Define o identificador único do produto.
	public void setIdProduct(UUID idProduct) { this.idProduct = idProduct; }

	// Retorna o nome do produto.
	public String getName() { return name; }

	// Define o nome do produto.
	public void setName(String name) { this.name = name; }

	// Retorna o valor do produto.
	public BigDecimal getValue() { return value; }

	// Define o valor do produto.
	public void setValue(BigDecimal value) { this.value = value; }

	// Retorna a descrição do produto.
	public String getDescription() { return description; }

	// Define a descrição do produto.
	public void setDescription(String description) { this.description = description; }
}
