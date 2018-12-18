package com.mediator;

public interface Mediator {
	void register(String name,Department t);
	void command(String name);
}
