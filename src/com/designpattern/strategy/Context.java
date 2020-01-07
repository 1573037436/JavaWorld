package com.designpattern.strategy;

public class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	public void printPrice(double s){
		System.out.println("您该报价"+strategy.getDiscount(s));
	}
}
