package com.example.examserver.domain;

import org.exolab.castor.types.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 11:51
 */
@Entity //对应数据库的注解
public class FivesensData {
    @Id
    private String userId;
    private DateTime create_time;
    private String empId;
    private String hearing;
    private String hearing_select;
    private String vision;
    private String vision_select;
    private String mouth;
    private String mouth_select;
    private String  Summarize;

    public DateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(DateTime create_time) {
        this.create_time = create_time;
    }

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

    public String getHearing() {
        return hearing;
    }

    public void setHearing(String hearing) {
        this.hearing = hearing;
    }

    public String getHearing_select() {
        return hearing_select;
    }

    public void setHearing_select(String hearing_select) {
        this.hearing_select = hearing_select;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getVision_select() {
        return vision_select;
    }

    public void setVision_select(String vision_select) {
        this.vision_select = vision_select;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getMouth_select() {
        return mouth_select;
    }

    public void setMouth_select(String mouth_select) {
        this.mouth_select = mouth_select;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }
}
