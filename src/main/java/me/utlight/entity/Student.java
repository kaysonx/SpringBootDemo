package me.utlight.entity;

import java.io.Serializable;

public class Student implements Serializable{
    private int Id;
    private String Name;
    private float sumScore;
    private float avgScore;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {

        return age;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSumScore(float sumScore) {
        this.sumScore = sumScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public float getSumScore() {
        return sumScore;
    }

    public float getAvgScore() {
        return avgScore;
    }
}
