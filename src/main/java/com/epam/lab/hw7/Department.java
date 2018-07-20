package com.epam.lab.hw7;

public class Department {
    private String deptNo;
    private String deptName;
    private String location;

    public Department() {

    }

    public Department(String deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("dept_no = %s\ndept_name = %s\nlocation = %s\n", this.deptNo, this.deptName, this.location);
    }
}
