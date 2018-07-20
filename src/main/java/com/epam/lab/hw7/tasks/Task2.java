package com.epam.lab.hw7.tasks;

import com.epam.lab.hw7.Department;
import com.epam.lab.hw7.dao.DepartmentDAO;
import org.apache.log4j.Logger;

import static com.epam.lab.hw7.tasks.CreateDBtask3.creation;

public class Task2 {
    private static final Logger LOG = Logger.getLogger(Task2.class);

    public static void main(String[] args) {
        creation();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = new Department("d4", "design", "Seattle");
        departmentDAO.add(department);
        LOG.info(departmentDAO.getAll());
        Task4 task4 = new Task4();
        task4.showData();
    }
}
