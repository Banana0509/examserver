package com.example.examserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 体检一般信息记录表
 */
@Entity //对应数据库的注解
public class GeneralData {

    @Id
    private String userId;
    private Float height;
    private Float weight;
    private Float waistline;
    private Float BMI;
    private Float bloodPressure;
    private String medicationHis;
    private String allergicHis;
    private String Summarize;

    public GeneralData() {
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

    public Float getWaistline() {
        return waistline;
    }

    public void setWaistline(Float waistline) {
        this.waistline = waistline;
    }

    public Float getBMI() {
        return BMI;
    }

    public void setBMI(Float BMI) {
        this.BMI = BMI;
    }

    public Float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getMedicationHis() {
        return medicationHis;
    }

    public void setMedicationHis(String medicationHis) {
        this.medicationHis = medicationHis;
    }

    public String getAllergicHis() {
        return allergicHis;
    }

    public void setAllergicHis(String allergicHis) {
        this.allergicHis = allergicHis;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }




}
