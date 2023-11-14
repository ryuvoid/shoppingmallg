//package com.javateam.shoppingmall.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.javateam.memberProject.domain.MemberDTO;
//import com.javateam.memberProject.domain.PageVO;
//import com.javateam.memberProject.service.MemberService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Controller
//@RequestMapping("/admin")
//@Slf4j
//public class PageController {
//
//	@Autowired
//	MemberService memberService;
//	
//	@GetMapping("/")
//	public String admin() {
//		
//		log.info("관리자 화면 admin");
//		// return "redirect:/admin/viewAll.do";
//		return "/welcome";
//	}
//	
//	@GetMapping("/viewAll.do")
//	public String adminView(@RequestParam(value="currPage", defaultValue="1", required=true) int currPage, 
//							@RequestParam(value="limit", defaultValue="10") int limit,
//							Model model) {
//		
//		log.info("관리자 화면");
//		List<MemberDTO> members = new ArrayList<>();
//		
//		
//		members = memberService.selectMembersByPaging(currPage, limit);
//		
//		// 총 인원 수
//		int listCount = memberService.selectMembersCount();
//		
//		log.info("총 인원수 : {}", listCount);
//		
//		// 총 페이지 수
//   		int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리
//		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21,...)
//   		int startPage = (((int) ((double)currPage / 10 + 0.9)) - 1) * 10 + 1;
//		// 현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30, ...)
//   	    int endPage = startPage + 10;
//   	    
//   	    if (endPage> maxPage) endPage = maxPage;
//   	    
//   	    PageVO pageVO = new PageVO();
//		pageVO.setEndPage(endPage);
//		pageVO.setListCount(listCount);
//		pageVO.setMaxPage(maxPage);
//		pageVO.setCurrPage(currPage);
//		pageVO.setStartPage(startPage);
//		
//		model.addAttribute("pageVO", pageVO);
//		model.addAttribute("members", members);
//		
//		return "/admin/viewAll";
//	} //
//	
//} //