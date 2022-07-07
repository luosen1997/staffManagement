package com.etc.model;

public class Dept {

	
	private Integer id;
	
	private String deptname;
	
	private String deptremark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptremark() {
		return deptremark;
	}

	public void setDeptremark(String deptremark) {
		this.deptremark = deptremark;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptname=" + deptname + ", deptremark=" + deptremark + "]";
	}

}
