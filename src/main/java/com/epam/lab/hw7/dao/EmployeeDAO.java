package com.epam.lab.hw7.dao;

import com.epam.lab.hw7.Employee;
import com.epam.lab.hw7.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends JDBCConnection {
    private Connection connection = getConnection();

    void add(Employee employee) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO employee (`emp_no`, `emp_fname`, `emp_lname`, `home`, `dept_no`) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getEmpNo());
            preparedStatement.setString(2, employee.getEmpFname());
            preparedStatement.setString(3, employee.getEmpLname());
            preparedStatement.setString(4, employee.getHome());
            preparedStatement.setString(5, employee.getDeptNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    Employee getEmployee(int empNo) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM employee WHERE emp_no = ?";
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            employee.setEmpNo(resultSet.getInt(1));
            employee.setEmpFname(resultSet.getString(2));
            employee.setEmpLname(resultSet.getString(3));
            employee.setHome(resultSet.getString(4));
            employee.setDeptNo(resultSet.getString(5));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    void update(Employee employee) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE employee SET emp_fname = ?, emp_lname = ?, home = ?, dept_no = ? WHERE emp_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmpFname());
            preparedStatement.setString(2, employee.getEmpLname());
            preparedStatement.setString(3, employee.getHome());
            preparedStatement.setString(4, employee.getDeptNo());
            preparedStatement.setInt(5, employee.getEmpNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void remove(Employee employee) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM employee WHERE emp_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getEmpNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
