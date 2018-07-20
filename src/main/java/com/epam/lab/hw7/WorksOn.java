package com.epam.lab.hw7;

import java.sql.Date;

public class WorksOn {
    private int empNo;
    private String projectNo;
    private String job;
    private Date enterDate;

    public WorksOn() {
    }

    public WorksOn(int empNo, String projectNo, String job, Date enterDate) {

        this.empNo = empNo;
        this.projectNo = projectNo;
        this.job = job;
        this.enterDate = enterDate;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}
