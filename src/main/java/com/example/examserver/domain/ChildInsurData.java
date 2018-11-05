package com.example.examserver.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 10:01
 */
@Entity //对应数据库的注解
public class ChildInsurData {
    @Id
    private String userId;
    private String empId;
    private Float height;
    private Float weight;
    private Float pre_height;
    private Float bloodPressureL;
    private Float bloodPressureH;
    private String feed_status;
    private String feed_status_select;
    private String  grade;
    private String  grade_select;
    private String  Summarize;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getPre_height() {
        return pre_height;
    }

    public void setPre_height(Float pre_height) {
        this.pre_height = pre_height;
    }

    public Float getBloodPressureL() {
        return bloodPressureL;
    }

    public void setBloodPressureL(Float bloodPressureL) {
        this.bloodPressureL = bloodPressureL;
    }

    public Float getBloodPressureH() {
        return bloodPressureH;
    }

    public void setBloodPressureH(Float bloodPressureH) {
        this.bloodPressureH = bloodPressureH;
    }

    public String getFeed_status() {
        return feed_status;
    }

    public void setFeed_status(String feed_status) {
        this.feed_status = feed_status;
    }

    public String getFeed_status_select() {
        return feed_status_select;
    }

    public void setFeed_status_select(String feed_status_select) {
        this.feed_status_select = feed_status_select;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade_select() {
        return grade_select;
    }

    public void setGrade_select(String grade_select) {
        this.grade_select = grade_select;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }
}
