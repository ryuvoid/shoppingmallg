package com.javateam.memberProject.domain;

import lombok.Data;

@Data
public class PageVO {
	
	/** 시작 페이지 */
	private int startPage;
	
	/** 마지막 페이지 */
	private int endPage;
	
	/** 총 페이지 수 */
	private int maxPage;
	
	/** 현재 페이지 */
	private int currPage;
	
	/** 총 인원/게시글 수 */
	private int listCount;	

}
