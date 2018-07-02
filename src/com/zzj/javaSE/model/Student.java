package com.zzj.javaSE.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "student", propOrder = { "name", "number", "className", "sex" ,"hobby"}) 
public class Student {
	private String name;
	private String sex;
	private Integer number;
	private String className;
	private List<String> hobby;

	@XmlElement//@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement//@XmlAttribute
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@XmlElement//@XmlAttribute
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@XmlElement//@XmlAttribute
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@XmlList
	@XmlElementWrapper
	@XmlElement//@XmlAttribute
	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public Student(String name, String sex, Integer number, String className, List<String> hobby) {
		super();
		this.name = name;
		this.sex = sex;
		this.number = number;
		this.className = className;
		this.hobby = hobby;
	}

	public Student() {
		super();
	}

}
