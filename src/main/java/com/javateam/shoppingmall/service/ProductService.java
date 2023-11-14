package com.javateam.shoppingmall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.shoppingmall.dao.ProductDAO;
import com.javateam.shoppingmall.vo.ProductVO;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO productDAO;

	@Transactional(readOnly = true)
	public List<ProductVO> getProductsByPaging(int page, int limit){

    	Pageable pageable = PageRequest.of(page-1, limit);
		
    	return productDAO.findAll(pageable).getContent();
	}
	
	
	@Transactional(readOnly = true)
	public long countProducts() {
		
		return	productDAO.count();
				
	}
	

}
