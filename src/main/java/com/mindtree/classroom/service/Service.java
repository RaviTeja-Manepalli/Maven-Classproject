package com.mindtree.classroom.service;

import com.mindtree.classroom.Exceptions.ServiceException.ServiceException;
import com.mindtree.classroom.entity.Classroom;
import com.mindtree.classroom.entity.Student;

public interface Service {

	public Classroom insertClass(String classId, String className, int count) throws ServiceException;

	public Student insertStudent(String classId, String name, String studentId, int age) throws ServiceException;

	public boolean checkIdPresent(String Id) throws ServiceException;

	public boolean getDetails(String Id) throws ServiceException;

	public boolean updateAge(String id, int age) throws ServiceException;
	public boolean checkClass(String id)throws ServiceException;
}
