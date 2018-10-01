package com.leon.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Category {
	private int id;
	private float temp;
	private float humi;
	private int illu;
	private Timestamp date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + temp + "]";
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getHumi() {
		return humi;
	}
	public void setHumi(float humi) {
		this.humi = humi;
	}
	public int getIllu() {
		return illu;
	}
	public void setIllu(int illu) {
		this.illu = illu;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
}
