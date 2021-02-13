package com.mindtree.classroom.service;

import com.mindtree.classroom.Exceptions.DAOException.DAOException;
import com.mindtree.classroom.Exceptions.ServiceException.ServiceException;
import com.mindtree.classroom.dao.DAO;
import com.mindtree.classroom.dao.DAOService;
import com.mindtree.classroom.entity.Classroom;
import com.mindtree.classroom.entity.Student;

public class ServiceImpl implements Service {

	static DAO dao = new DAOService();

	@Override
	public Classroom insertClass(String classId, String className, int count) throws ServiceException {
		// TODO Auto-generated method stub
		Classroom c = dao.storeClassDAO(classId, className, count);

		return c;
	}

	@Override
	public boolean checkIdPresent(String Id) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = dao.checkIdDAO(Id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException();
		}
		return res;
	}

	@Override
	public boolean getDetails(String Id) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = dao.getStudentDetailsDAO(Id);
		return res;
	}

	@Override
	public Student insertStudent(String classId, String name, String studentId, int age) throws ServiceException {
		// TODO Auto-generated method stub

		Student s = null;
		try {
			s = dao.storeStudentDAO(classId, name, studentId, age);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		return s;
	}

	@Override
	public boolean updateAge(String id, int age) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = dao.updateAgeDAO(id, age);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean checkClass(String id) throws ServiceException {
		// TODO Auto-generated method stub
		boolean res = dao.checkIDClassDAO(id);
		return res;
	}

}
