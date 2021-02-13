package com.mindtree.classroom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.classroom.DbUtils.DbUtils;
import com.mindtree.classroom.Exceptions.DAOException.DAOException;
import com.mindtree.classroom.entity.Classroom;
import com.mindtree.classroom.entity.Student;

public class DAOService implements DAO {
	static DbUtils db = new DbUtils();

	@Override
	public Classroom storeClassDAO(String classId, String className, int count) throws DAOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection con = db.getConnectionSQL();

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		String sql = String.format("insert into class values('%s','%s', %d)", classId, className, count);

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		Classroom c = new Classroom(classId, className, count);
		db.closeConnection(stmt);

		db.closeConnection(con);
		return c;

	}

	@Override
	public Student storeStudentDAO(String classId, String name, String studentId, int age) throws DAOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection con = db.getConnectionSQL();

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		String sql = String.format("insert into student values('%s','%s','%s', %d)", classId, name, studentId, age);

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
		Student s = new Student(classId, name, age);
		db.closeConnection(stmt);

		db.closeConnection(con);
		return s;
	}

	@Override
	public boolean getStudentDetailsDAO(String id) throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT student.classId, student.studentName,student.age,student.studentId,class.className,class.count"
				+ " FROM student inner join class on student.classId =class.classId where student.studentId='" + id
				+ "' ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		db.closeConnection(stmt);


		db.closeConnection(con);

		return empty;
	}

	@Override
	public boolean checkIdDAO(String id) throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT studentId from student where studentId= '" + id + "' ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}


		db.closeConnection(stmt);

		db.closeConnection(con);

		return empty;
	}

	@Override
	public boolean updateAgeDAO(String id, int age) throws DAOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection con = db.getConnectionSQL();

		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		String sql = "delete from student where studentId = '"+id+"'";
		System.out.println(sql);

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

		db.closeConnection(stmt);

		db.closeConnection(con);
		return false;
	}

	@Override
	public boolean checkIDClassDAO(String id) throws DAOException {
		// TODO Auto-generated method stub
		String sql = "SELECT classId from class where classId= '" + id + "' ";
		Statement stmt = null;
		Connection con = db.getConnectionSQL();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}

		boolean empty = false;

		try {
			while (rs.next()) {
				empty = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);

		}


		db.closeConnection(stmt);

		db.closeConnection(con);

		return empty;
	}

}
