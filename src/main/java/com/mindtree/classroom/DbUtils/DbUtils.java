package com.mindtree.classroom.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.classroom.Exceptions.DAOException.DBUtilException;


public class DbUtils {
	public Connection getConnectionSQL() throws DBUtilException {
		String url = "jdbc:mysql://localhost:3306/class";
		String userName = "root";
		String password = "12345678";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DBUtilException(e);
		}
		return con;
	}

	public void closeConnection(Connection con) throws DBUtilException {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			throw new DBUtilException(e);
		}

	}

	public void closeConnection(Statement st) throws DBUtilException {
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			throw new DBUtilException(e);
		}

	}


}
