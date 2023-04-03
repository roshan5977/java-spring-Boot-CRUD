package com.darkworldbank.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_")
@Data
public class User {
	
	@Column(name = "user_Id")
	@Id 
	@GeneratedValue
	private  Integer userId;
	@Column(name="user_Name")
	private String userName;
	@Column(name="email_Id")
	private String emailId;
	@Column(name = "user_Age")
    private int userAge;
}
