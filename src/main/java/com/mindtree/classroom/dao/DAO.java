package com.mindtree.classroom.dao;

import com.mindtree.classroom.Exceptions.DAOException.DAOException;
import com.mindtree.classroom.Exceptions.DAOException.DBUtilException;
import com.mindtree.classroom.entity.Classroom;
import com.mindtree.classroom.entity.Student;

public interface DAO {

	public Classroom storeClassDAO(String classId, String className, int count) throws  DAOException;

	public Student storeStudentDAO(String classId, String name, String studentId, int age) throws Exception;

	public boolean getStudentDetailsDAO(String id) throws DAOException;

	public boolean checkIdDAO(String id) throws DAOException;

	public boolean updateAgeDAO(String id, int age) throws DAOException;
	 
	public boolean checkIDClassDAO(String id) throws DAOException;

}
