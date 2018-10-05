package edu.spring.sample.example.rabbitmq.model;

import java.io.Serializable;

public class Order extends AbstractVO implements Serializable {
	private static final long serialVersionUID = -3213087636244564328L;
	private String orderNumber;
	private String productId;
	private double amount;

	public Order() {
	}

	public Order(String orderNumber, String productId, double amount) {
		this.orderNumber = orderNumber;
		this.productId = productId;
		this.amount = amount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
