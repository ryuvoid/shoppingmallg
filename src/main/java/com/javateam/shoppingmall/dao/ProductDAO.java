package com.javateam.shoppingmall.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javateam.shoppingmall.vo.ProductVO;

public interface ProductDAO extends PagingAndSortingRepository<ProductVO, Integer>{

	
	
}
