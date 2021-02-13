package com.mindtree.classroom.entity;

public class Student {
	private String StudentId;
	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(String studentId, String name, int age) {
		super();
		StudentId = studentId;
		this.name = name;
		this.age = age;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

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

}
