package com.etc.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Not {

	private Integer id;
	
	private String notname;
	
	private String notcontent;
	
	private Date createtime;
	
	private String notpeople;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotname() {
		return notname;
	}

	public void setNotname(String notname) {
		this.notname = notname;
	}

	public String getNotcontent() {
		return notcontent;
	}

	public void setNotcontent(String notcontent) {
		this.notcontent = notcontent;
	}
	
	@JsonFormat(pattern="yyyy年MM月dd日")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNotpeople() {
		return notpeople;
	}

	public void setNotpeople(String notpeople) {
		this.notpeople = notpeople;
	}
}
