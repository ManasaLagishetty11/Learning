package com.example;

import javax.persistence.Embeddable;

@Embeddable
public class School {

    private String schoolName;

    private  String area;

    public School() {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
