package model;

public class User {
	// 1. encapsulate
	private String name;
	private int age;
	
	// 2. constructor
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 3. accessor
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
