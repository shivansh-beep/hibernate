package com.flipkart.products;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FlipkartDTO implements Serializable {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "product_ID")
	private int id;
	private String product_name;
	private double product_cost;
	private String product_color;
	private String description;
	private int number_of_products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_cost() {
		return product_cost;
	}

	public void setProduct_cost(double product_cost) {
		this.product_cost = product_cost;
	}

	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumber_of_products() {
		return number_of_products;
	}

	public void setNumber_of_products(int number_of_products) {
		this.number_of_products = number_of_products;
	}
}
