package com.practice.coding.senddataparcelable;

import java.io.Serializable;

public class MyModel implements Serializable {
    private String name, education, age;
    public MyModel() {

    }

    public MyModel(String name, String education, String age) {
        this.name = name;
        this.education = education;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
