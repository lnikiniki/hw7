package com.epam.lab.hw7.dao;

import com.epam.lab.hw7.JDBCConnection;
import com.epam.lab.hw7.WorksOn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorksOnDAO extends JDBCConnection {
    private Connection connection = getConnection();

    void add(WorksOn worksOn) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO works_on (`emp_no`, `project_no`, `job`, `enter_date`) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, worksOn.getEmpNo());
            preparedStatement.setString(2, worksOn.getProjectNo());
            preparedStatement.setString(3, worksOn.getJob());
            preparedStatement.setDate(4, worksOn.getEnterDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<WorksOn> getAll() {
        List<WorksOn> works = new ArrayList<>();
        String sql = "SELECT * FROM works_on";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                WorksOn department = new WorksOn(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
                works.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return works;
    }

    WorksOn getWorksOn(int empNo, String projectNo) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM works_on WHERE emp_no = ? AND project_no = ?";
        WorksOn worksOn = new WorksOn();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empNo);
            preparedStatement.setString(2, projectNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            worksOn.setEmpNo(resultSet.getInt(1));
            worksOn.setProjectNo(resultSet.getString(2));
            worksOn.setJob(resultSet.getString(3));
            worksOn.setEnterDate(resultSet.getDate(4));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return worksOn;
    }

    void update(WorksOn worksOn) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE works_on SET job = ?, enter_date = ? WHERE emp_no = ? AND project_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, worksOn.getJob());
            preparedStatement.setDate(2, worksOn.getEnterDate());
            preparedStatement.setInt(3, worksOn.getEmpNo());
            preparedStatement.setString(4, worksOn.getProjectNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void remove(WorksOn worksOn) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM works_on WHERE emp_no = ? AND project_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, worksOn.getEmpNo());
            preparedStatement.setString(2, worksOn.getProjectNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
