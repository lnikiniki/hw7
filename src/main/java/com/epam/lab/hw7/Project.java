package com.epam.lab.hw7;

public class Project {
    private String projectNo;
    private String projectName;
    private int budget;

    public Project() {
    }

    public Project(String projectNo, String projectName, int budget) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.budget = budget;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
