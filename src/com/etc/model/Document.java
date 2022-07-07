package com.etc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Document {
    private Integer documentId;
    private String documentTitle;
    private Date createDate;
    private String documentPeople;
    private String documentRemark;
    private String documentPath;
    
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	@JsonFormat(pattern = "yyyy年MM月dd日")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDocumentPeople() {
		return documentPeople;
	}
	public void setDocumentPeople(String documentPeople) {
		this.documentPeople = documentPeople;
	}
	public String getDocumentRemark() {
		return documentRemark;
	}
	public void setDocumentRemark(String documentRemark) {
		this.documentRemark = documentRemark;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
    
}
