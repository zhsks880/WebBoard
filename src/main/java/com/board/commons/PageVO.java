package com.board.commons;

public class PageVO {
	
	private int page; //사용자가 선택한 페이지의 번호.
	private int cpp; //한 화면에 보여질 게시물의 개수.
	
	public PageVO() {
		page = 1;
		cpp = 10;
	}	
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getCpp() {
		return cpp;
	}
	
	public void setCpp(int cpp) {
		this.cpp = cpp;
	}
	
	@Override
	public String toString() {
		return "PageVO [page=" + page + ", cpp=" + cpp + "]";
	}
	
}