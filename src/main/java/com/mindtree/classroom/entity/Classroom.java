package com.mindtree.classroom.entity;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private String classId;
	private String className;
	private int count;
	private List<Student> st = new ArrayList<Student>();

	public Classroom() {
		super();
	}

	public Classroom(String classId, String className, int count) {
		super();
		this.classId = classId;
		this.className = className;
		this.count = count;
	}

	public Classroom(List<Student> st) {
		super();
		this.st = st;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Student> getSt() {
		return st;
	}

	public void setSt(List<Student> st) {
		this.st = st;
	}

}
