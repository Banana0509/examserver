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
    private String empId;
    private Float height;
    private Float weight;
    private Float waistline;
    private Float BMI;
    private Float bloodPressureL;
    private Float  bloodPressureH;
    private String  medicationHis;
    private String medicationHis_select;
    private String allergicHis;
    private String allergicHis_select;
    private String Summarize;

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

    public String getMedicationHis() {
        return medicationHis;
    }

    public void setMedicationHis(String medicationHis) {
        this.medicationHis = medicationHis;
    }

    public String getMedicationHis_select() {
        return medicationHis_select;
    }

    public void setMedicationHis_select(String medicationHis_select) {
        this.medicationHis_select = medicationHis_select;
    }

    public String getAllergicHis() {
        return allergicHis;
    }

    public void setAllergicHis(String allergicHis) {
        this.allergicHis = allergicHis;
    }

    public String getAllergicHis_select() {
        return allergicHis_select;
    }

    public void setAllergicHis_select(String allergicHis_select) {
        this.allergicHis_select = allergicHis_select;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }
}
