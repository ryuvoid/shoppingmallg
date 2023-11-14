package com.javateam.shoppingmall.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PRODUCT_TBL")
@Data
public class ProductVO {
	
	@Id
	@Column(name="PRODUCT_ID")
	private int productId;

	@Column(name="PRODUCT_DETAIL")
	private String productDetail;
	
	@Column(name="PRODUCT_IMAGE")
	private String productImage;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_PRICE")
	private int productPrice;
	
	@Column(name="PRODUCT_QUANTITY")
	private int productQuantity;
	
	@Column(name="PRODUCT_REGDATE")
	private Date productRegdate;
	
	@Column(name="PRODUCT_SALE_PRICE")
	private int productSalePrice;
	
	
}
