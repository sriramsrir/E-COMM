package com.joint.joint.Entity;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EmpPersonal")
public class EmpPersonalEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private Long ph=(long)(Math.random()*Math.pow(10, 10));
private int age;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Long getPh() {
	return ph;
}
public void setPh(Long ph) {
	this.ph = ph;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@OneToOne(mappedBy="per",cascade=CascadeType.ALL)
private EmployeeOffEntity off;

}