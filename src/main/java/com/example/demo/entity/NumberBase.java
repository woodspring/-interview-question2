package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "numberbase")
//@Data
public class NumberBase {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numId;
	
	@Column(name="number_string")
	private String numberStr;
	
	public NumberBase() {}
	
	public NumberBase(long mumId, String numberString) {
		this.numId = numId;
		this.numberStr = numberString;
	}

	public long getNumId() {
		return numId;
	}

	public void setNumId(long numId) {
		this.numId = numId;
	}

	public String getNumberStr() {
		return numberStr;
	}

	public void setNumberStr(String numberStr) {
		this.numberStr = numberStr;
	}

}
