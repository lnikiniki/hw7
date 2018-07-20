package com.epam.lab.hw7.dao;

import com.epam.lab.hw7.Department;
import com.epam.lab.hw7.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends JDBCConnection {
    private Connection connection = getConnection();

    public void add(Department department) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO department (`dept_no`, `dept_name`, `location`) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDeptNo());
            preparedStatement.setString(2, department.getDeptName());
            preparedStatement.setString(3, department.getLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM department";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department department = new Department(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department getDepartment(String deptNo) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM department WHERE dept_no = ?";
        Department department = new Department();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, deptNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            department.setDeptNo(resultSet.getString(1));
            department.setDeptName(resultSet.getString(2));
            department.setDeptName(resultSet.getString(3));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public void update(Department department) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE department SET dept_name = ?, location = ? WHERE dept_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDeptName());
            preparedStatement.setString(2, department.getLocation());
            preparedStatement.setString(3, department.getDeptNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Department department) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM department WHERE dept_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDeptNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
