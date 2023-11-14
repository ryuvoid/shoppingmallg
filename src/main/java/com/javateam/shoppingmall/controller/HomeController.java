package com.javateam.shoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javateam.shoppingmall.service.ProductService;
import com.javateam.shoppingmall.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String home(Model model) {
		
		log.info("home");
		
		model.addAttribute("products", productService.getProductsByPaging(1, 20));
		return "index";
	}
	
	@GetMapping("list")
	public String list(@RequestParam(value="page",defaultValue = "1") int page, Model model) {
		
		log.info("list");
		
		// 한 페이지 당 상품 개수
		int limit = 20;
		
		// 총 상품 개수
		int listCount = (int)productService.countProducts();
		
		// 총 페이지 수
   		// int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리
		int maxPage = PageVO.getMaxPage(listCount, limit);
		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21,...)
   		// int startPage = (((int) ((double)currPage / 10 + 0.9)) - 1) * 10 + 1;
		//int startPage = PageVO.getStartPage(page, limit);
		int startPage = 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30, ...)
   	    //int endPage = startPage + 10;
		int endPage = maxPage;
   	    if (endPage> maxPage) endPage = maxPage;
   	    
   	    PageVO pageVO = new PageVO();
		pageVO.setEndPage(endPage);
		pageVO.setListCount(listCount);
		pageVO.setMaxPage(maxPage);
		pageVO.setCurrPage(page);
		pageVO.setStartPage(startPage);
		
		pageVO.setPrePage(pageVO.getCurrPage()-1 < 1 ? 1 : pageVO.getCurrPage()-1);
		pageVO.setNextPage(pageVO.getCurrPage()+1 > pageVO.getEndPage() ? pageVO.getEndPage() : pageVO.getCurrPage()+1);
	
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("products", productService.getProductsByPaging(page, 20));
		
		return "gallery";
	}
}
