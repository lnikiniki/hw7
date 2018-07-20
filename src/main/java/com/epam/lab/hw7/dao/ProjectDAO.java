package com.epam.lab.hw7.dao;

import com.epam.lab.hw7.JDBCConnection;
import com.epam.lab.hw7.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends JDBCConnection {
    private Connection connection = getConnection();

    void add(Project project) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO project (`project_no`, `project_name`, `budget`) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getProjectNo());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setInt(3, project.getBudget());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM project";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Project department = new Project(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                projects.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    Project getProject(String progectNo) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM project WHERE project_no = ?";
        Project project = new Project();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, progectNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            project.setProjectNo(resultSet.getString(1));
            project.setProjectName(resultSet.getString(2));
            project.setBudget(resultSet.getInt(3));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    void update(Project project) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE project SET project_name = ?, budget = ? WHERE project_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setInt(2, project.getBudget());
            preparedStatement.setString(3, project.getProjectNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void remove(Project project) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM project WHERE project_no = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getProjectNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
