package com.zzj.javaSE.model;

public class Employee implements Cloneable {
	private String name;
	private int age;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Employee() {
		super();
	}

	// 实现浅克隆
	@Override
	public Object clone(){
		Employee employee = null;
		try {
			employee = (Employee) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//此处实现深克隆
		//employee.address = (Address) address.clone();
		return employee;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	
}
