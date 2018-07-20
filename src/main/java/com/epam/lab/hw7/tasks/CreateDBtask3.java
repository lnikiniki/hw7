package com.epam.lab.hw7.tasks;

import java.sql.*;

class CreateDBtask3 {
    static void creation() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "22988922");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS `newdb`");
            statement.executeUpdate("CREATE database newdb");
            statement.executeUpdate("USE newdb");
            statement.executeUpdate("CREATE TABLE `department` (" +
                    "  `dept_no` varchar(45) NOT NULL," +
                    "  `dept_name` varchar(45) DEFAULT NULL," +
                    "  `location` varchar(45) DEFAULT NULL," +
                    "  PRIMARY KEY (`dept_no`)" +
                    ") ");
            statement.executeUpdate("INSERT INTO `department` VALUES ('d1','research','Dallas'),('d2','accounting','Seattle'),('d3','marketing','Dallas');");
            statement.executeUpdate("CREATE TABLE `employee` (" +
                    "  `emp_no` int(11) NOT NULL," +
                    "  `emp_fname` varchar(45) DEFAULT NULL," +
                    "  `emp_lname` varchar(45) DEFAULT NULL," +
                    "  `home` varchar(45) DEFAULT NULL," +
                    "  `dept_no` varchar(45) NOT NULL," +
                    "  PRIMARY KEY (`emp_no`)," +
                    "  KEY `dept_no_idx` (`dept_no`)," +
                    "  CONSTRAINT `dept_no` FOREIGN KEY (`dept_no`) REFERENCES `department` (`dept_no`)" +
                    ")");
            statement.executeUpdate("INSERT INTO `employee` VALUES (2581,'Elke','Hansel','Seattle','d2'),(9031,'Elsa','Bertoni','Dallas','d2'),(10102,'Ann','Jones','Seattle','d3'),(18316,'John','Barrimore','Seattle','d1'),(25348,'Matthew','Smith','Dallas','d3'),(28559,'Sybill','Moser','Dallas','d1'),(29346,'James','James','Dallas','d2');");
            statement.executeUpdate("CREATE TABLE `project` (" +
                    "  `project_no` varchar(45) NOT NULL," +
                    "  `project_name` varchar(45) DEFAULT NULL," +
                    "  `budget` int(11) DEFAULT NULL," +
                    "  PRIMARY KEY (`project_no`)" +
                    ")");
            statement.executeUpdate("INSERT INTO `project` VALUES ('p1','Apollo',120000),('p2','Gemini',95000),('p3','Mercury',186500); ");
            statement.executeUpdate("CREATE TABLE `works_on` (" +
                    "  `emp_no` int(11) NOT NULL," +
                    "  `project_no` varchar(45) NOT NULL," +
                    "  `job` varchar(45) DEFAULT NULL," +
                    "  `enter_date` datetime DEFAULT NULL," +
                    "  KEY `project_no_idx` (`project_no`)," +
                    "  KEY `emp_no_idx` (`emp_no`)" +
                    ")");
            statement.executeUpdate("INSERT INTO `works_on` VALUES (10102,'p1','analyst','2006-10-01 00:00:00'),(10102,'p3','manager','2008-01-01 00:00:00'),(25348,'p2','clerk','2007-02-15 00:00:00'),(18316,'p2',NULL,'2007-06-01 00:00:00'),(29346,'p2',NULL,'2006-12-15 00:00:00'),(2581,'p3','analyst','2007-10-15 00:00:00'),(9031,'p1','manager','2007-04-15 00:00:00'),(28559,'p1',NULL,'2007-08-01 00:00:00'),(28559,'p2','clerk','2008-02-01 00:00:00'),(9031,'p3','clerk','2006-11-15 00:00:00'),(29346,'p1','clerk','2007-01-04 00:00:00');");
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
