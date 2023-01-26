package com.nareshit.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emptab")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="eid")
	private Integer Empid;
	
	
	@Column(name="ename")
	@NotEmpty(message = "Name Can not be Empty") 
	@Size(min=3,max=10)
	private String EmpName;
	
	@Column(name="esal")
	private Double Salary;
	
	
	@Column(name="egen")
	private String Gender;
	
	@Column(name="edept")
	private String EmpDept;
	
	
	@Column(name="eadd")
	private String EmpAddress;
}
