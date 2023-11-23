package com.kh.springdb.model;

import java.util.Date;

public class UserModel {
	
	/*
		MNO	NUMBER
		MNAME	VARCHAR2(50 BYTE)
		MEMAIL	VARCHAR2(100 BYTE)
		MBIRTH	DATE
	 */
	
	//멤버변수
	private int mno;
	private String mname;
	private String memail;
	private Date mbirth;
	
	//Getter&Setter----------------
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}
	
}
