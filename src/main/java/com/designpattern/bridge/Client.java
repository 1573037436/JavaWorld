package com.designpattern.bridge;
/**
 * 桥模式：将抽象化与实现化脱耦，使得二者可以独立的变化，也就是说将他们之间的强关联变成弱关联，
 * 也就是指在一个软件系统的抽象化和实现化之间使用组合/聚合关系而不是继承关系，从而使两者可以独立的变化。
 * @author zhoucheng
 *
 */
public class Client {

	
	public static void main(String[] args) {
		Computer computer=new Desktop(new Lenovo());
		computer.salecom();
	}

}