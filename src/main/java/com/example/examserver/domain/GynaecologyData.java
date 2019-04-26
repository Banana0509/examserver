package com.example.examserver.domain;

import org.exolab.castor.types.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 11:54
 */
@Entity //对应数据库的注解
public class GynaecologyData {
    @Id
    private String userId;
    private DateTime create_time;
    private String empId;
    private String lump;
    private String lump_select;
    private String skin;
    private String skin_select;
    private String breast;
    private String breast_select;
    private String hernia;
    private String hernia_select;
    private String varix;
    private String varix_select;
    private String Summarize;
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

    public String getLump() {
        return lump;
    }

    public void setLump(String lump) {
        this.lump = lump;
    }

    public String getLump_select() {
        return lump_select;
    }

    public void setLump_select(String lump_select) {
        this.lump_select = lump_select;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getSkin_select() {
        return skin_select;
    }

    public void setSkin_select(String skin_select) {
        this.skin_select = skin_select;
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public String getBreast_select() {
        return breast_select;
    }

    public void setBreast_select(String breast_select) {
        this.breast_select = breast_select;
    }

    public String getHernia() {
        return hernia;
    }

    public void setHernia(String hernia) {
        this.hernia = hernia;
    }

    public String getHernia_select() {
        return hernia_select;
    }

    public void setHernia_select(String hernia_select) {
        this.hernia_select = hernia_select;
    }

    public String getVarix() {
        return varix;
    }

    public void setVarix(String varix) {
        this.varix = varix;
    }

    public String getVarix_select() {
        return varix_select;
    }

    public void setVarix_select(String varix_select) {
        this.varix_select = varix_select;
    }

    public String getSummarize() {
        return Summarize;
    }

    public void setSummarize(String summarize) {
        Summarize = summarize;
    }
}
