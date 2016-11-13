package com.company.jasperreportsdemo.entities.queryObjects;

import java.math.BigDecimal;

import com.company.jasperreportsdemo.entities.Category;

public class ProductCategorySum {

	private BigDecimal priceOerCategory;
	private Category category;

	public ProductCategorySum(BigDecimal priceOerCategory, Category category) {
		super();
		this.priceOerCategory = priceOerCategory;
		this.category = category;
	}

	public BigDecimal getPriceOerCategory() {
		return priceOerCategory;
	}

	public void setPriceOerCategory(BigDecimal priceOerCategory) {
		this.priceOerCategory = priceOerCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
