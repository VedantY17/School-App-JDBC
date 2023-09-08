package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {

	HelperClass helperClass = new HelperClass();
	Connection connection = null;

	// to update data

//	public boolean updateStudents(int id) {
//
//		// connection establishment
//		connection = helperClass.getConnection();
//		String sql = "UPDATE student SET name=?, email =? WHERE ID = ?";
//
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//			preparedStatement.setInt(1, id);
//
//			int i = preparedStatement.executeUpdate();
//
//			if (i > 0) {
//				return true;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	// to get data
	public int getStudent(int id) {

		connection = helperClass.getConnection();

		String sql = "SELECT * FROM student WHERE Id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return id;

	}

	// to get all data
	public void getAll() {
		connection = helperClass.getConnection();

		String sql = "SELECT * FROM student";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// to delete a data
	public boolean deleteStudentById(int id) {

		// connection establishment
		connection = helperClass.getConnection();
		String sql = "DELETE FROM student WHERE ID = ?";

		// creating statement
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			// execute query
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	// to save a student data
	public Student saveStudent(Student student) {
		connection = helperClass.getConnection();
		String sql = "INSERT INTO student VALUES(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// passed the values to delimiters/placeholders ---> ?
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());

			// execute
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return student;
	}
}
