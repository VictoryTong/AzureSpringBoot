package com.stock.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Stock {
	
	private UUID id;
	private String name;
	private BigDecimal currentPrice;
	private LocalDateTime lastUpdate;
	
	public Stock() {
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(BigDecimal price) {
		this.currentPrice = price;
	}
	
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}

