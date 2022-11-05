package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Employee {

	@Id
	private int empId;
	@Column
	private String empName;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String password;

}
