package com.darkworldbank.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pin_code")
	private Long pinCode;
	@Column(name = "house_num")
	private int houseNum;
	@Column(name = "at_post")
	private String atPost;
	@Column(name = "police_station")
	private String policeStation;
	
//	private User user;

}
