package me.utlight.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Score")
public class Score implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, name = "stuId")
    private int stuId;

    @Column(nullable = false, name = "subjectName")
    private String subjectName;

    @Column(name = "score",nullable = false)
    private float score;

    @Column(name = "examTime",nullable = false)
    private Date examTime;

    public Score() {
    }

    public Score(String subjectName, float score, Date examTime) {
        this.subjectName = subjectName;
        this.score = score;
        this.examTime = examTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public int getId() {

        return id;
    }

    public int getStuId() {
        return stuId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public float getScore() {
        return score;
    }

    public Date getExamTime() {
        return examTime;
    }
}
