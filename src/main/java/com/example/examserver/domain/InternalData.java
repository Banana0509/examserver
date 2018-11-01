package com.example.examserver.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 11:38
 */
@Entity //对应数据库的注解
public class InternalData {
    @Id
    private String userId;
    private String Hypertension;
    private String Hypertension_select;
    private String HeartDisease;
    private String HeartDisease_select;
    private String CerebralInfraction;
    private String CerebralInfraction_select;
    private String Diabetes;
    private String Diabetes_select;
    private String Tumor;
    private String Tumor_select;
    private String Summarize;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHypertension() {
        return Hypertension;
    }

    public void setHypertension(String hypertension) {
        Hypertension = hypertension;
    }

    public String getHypertension_select() {
        return Hypertension_select;
    }

    public void setHypertension_select(String hypertension_select) {
        Hypertension_select = hypertension_select;
    }

    public String getHeartDisease() {
        return HeartDisease;
    }

    public void setHeartDisease(String heartDisease) {
        HeartDisease = heartDisease;
    }

    public String getHeartDisease_select() {
        return HeartDisease_select;
    }

    public void setHeartDisease_select(String heartDisease_select) {
        HeartDisease_select = heartDisease_select;
    }

    public String getCerebralInfraction() {
        return CerebralInfraction;
    }

    public void setCerebralInfraction(String cerebralInfraction) {
        CerebralInfraction = cerebralInfraction;
    }

    public String getCerebralInfraction_select() {
        return CerebralInfraction_select;
    }

    public void setCerebralInfraction_select(String cerebralInfraction_select) {
        CerebralInfraction_select = cerebralInfraction_select;
    }

    public String getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(String diabetes) {
        Diabetes = diabetes;
    }

    public String getDiabetes_select() {
        return Diabetes_select;
    }

    public void setDiabetes_select(String diabetes_select) {
        Diabetes_select = diabetes_select;
    }

    public String getTumor() {
        return Tumor;
    }

    public void setTumor(String tumor) {
        Tumor = tumor;
    }

    public String getTumor_select() {
        return Tumor_select;
    }

    public void setTumor_select(String tumor_select) {
        Tumor_select = tumor_select;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }
}
