package com.many2many;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {

    @Id
    private int id;

    private String projectName;

    @ManyToMany
    private List<Employee> employeeList;

    public Project() {
    }

    public Project(int id, String projectName, List<Employee> employeeList) {
        this.id = id;
        this.projectName = projectName;
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
