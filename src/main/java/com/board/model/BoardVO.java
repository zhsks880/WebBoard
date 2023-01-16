package com.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int board_id;
	private String writer;
	private String title;
	private String content;
	private Timestamp reg_date;
	private int hit;
	private int adminC;

	public BoardVO() {
	}

	public BoardVO(int board_id, String writer, String title, String content, Timestamp reg_date, int hit, int adminC) {
		super();
		this.board_id = board_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.hit = hit;
		this.adminC = adminC;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getAdminC() {
		return adminC;
	}

	public void setAdminC(int adminC) {
		this.adminC = adminC;
	}

}
