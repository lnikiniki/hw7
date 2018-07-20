package com.epam.lab.hw7;

public class Employee {
    private int empNo;
    private String empFname;
    private String empLname;
    private String home;
    private String deptNo;

    public Employee() {

    }

    public Employee(int empNo, String empFname, String empLname, String home, String deptNo) {
        this.empNo = empNo;
        this.empFname = empFname;
        this.empLname = empLname;
        this.home = home;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLname() {
        return empLname;
    }

    public void setEmpLname(String empLname) {
        this.empLname = empLname;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
