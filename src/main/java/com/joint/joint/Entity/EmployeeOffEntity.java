package com.joint.joint.Entity;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EmpOfficial")
public class EmployeeOffEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private long salary=(long)Math.random()*100000;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="emp_per_id")
private EmpPersonalEntity per;
public EmpPersonalEntity getPer() {
	return per;
}
public void setPer(EmpPersonalEntity per) {
	this.per = per;
}

}