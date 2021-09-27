package com.sakthi.service.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "PROFILE")
@Data
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profile")
	@SequenceGenerator(name= "seq_profile", sequenceName = "seq_profile", initialValue = 500)
	private Long id;
	
	@Column(name = "JOIN_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joinDate;
	
	@Column(name = "IS_CONFIRMED")
	private boolean confirmed;
	
	@Column(name = "DEPARTMENT")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name = "CURRENT_PROJECT")
	private String currentProject;
}
