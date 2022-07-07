package com.etc.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Emp {
	
	private Integer id;
    private Integer deptid;
    private Integer jobid;
	private String empname;
    private String cardid;
    private String empaddress;
    private String postcode;
    private String emptel;
    private String empphone;
    private String qqnum;
    private String empemail;
    private Integer empsex;
    private String empparty;
    private Date empbirthday;
    private String emprace;
    private String empedu;
    private String empmajor;
    private String emphobby;
    private String empremark;
    private Date createdate;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public Integer getJobid() {
		return jobid;
	}
	public void setJobid(Integer jobid) {
		this.jobid = jobid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmptel() {
		return emptel;
	}
	public void setEmptel(String emptel) {
		this.emptel = emptel;
	}
	public String getEmpphone() {
		return empphone;
	}
	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getEmpemail() {
		return empemail;
	}
	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}
	public Integer getEmpsex() {
		return empsex;
	}
	public void setEmpsex(Integer empsex) {
		this.empsex = empsex;
	}
	public String getEmpparty() {
		return empparty;
	}
	public void setEmpparty(String empparty) {
		this.empparty = empparty;
	}
	public Date getEmpbirthday() {
		return empbirthday;
	}
	public void setEmpbirthday(Date empbirthday) {
		this.empbirthday = empbirthday;
	}
	public String getEmprace() {
		return emprace;
	}
	public void setEmprace(String emprace) {
		this.emprace = emprace;
	}
	public String getEmpedu() {
		return empedu;
	}
	public void setEmpedu(String empedu) {
		this.empedu = empedu;
	}
	public String getEmpmajor() {
		return empmajor;
	}
	public void setEmpmajor(String empmajor) {
		this.empmajor = empmajor;
	}
	public String getEmphobby() {
		return emphobby;
	}
	public void setEmphobby(String emphobby) {
		this.emphobby = emphobby;
	}
	public String getEmpremark() {
		return empremark;
	}
	public void setEmpremark(String empremark) {
		this.empremark = empremark;
	}
	@JsonFormat(pattern="yyyy年MM月dd日")
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
