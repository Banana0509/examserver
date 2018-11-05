package com.example.examserver.controller;

import com.example.examserver.ireport.ReportGenerate;
import com.example.examserver.repository.ChildInsurRepository;
import com.example.examserver.utils.DataBaseConfig;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.examserver.domain.ChildInsurData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 10:14
 */
@RestController
public class ChildInsurController {
    private final  static Logger logger = LoggerFactory.getLogger(ChildInsurController.class);

    @Autowired
    private ChildInsurRepository childInsurRepository;

    @Autowired
    private DataBaseConfig dataBaseConfig;


    private String pdfPath;

    @CrossOrigin
    @PostMapping(value = "/ChildInsurData")
    public ChildInsurData ChildInsurDataAdd(@RequestParam("userId") String userId,
                                            @RequestParam("empId") String empId,
                                            @RequestParam("height") Float height,
                                            @RequestParam("weight") Float weight,
                                            @RequestParam("pre_height") Float pre_height,
                                            @RequestParam("bloodPressureL") Float bloodPressureL,
                                            @RequestParam("bloodPressureH") Float bloodPressureH,
                                            @RequestParam("feed_status") String feed_status,
                                            @RequestParam("feed_status_select") String feed_status_select,
                                            @RequestParam("grade") String grade,
                                            @RequestParam("grade_select") String grade_select,
                                            @RequestParam("Summarize") String Summarize){
        logger.info("userId:"+userId);
        ChildInsurData data = new ChildInsurData();
        data.setUserId(userId);
        data.setEmpId(empId);
        data.setHeight(height);
        data.setWeight(weight);
        data.setPre_height(pre_height);
        data.setBloodPressureL(bloodPressureL);
        data.setBloodPressureH(bloodPressureH);
        data.setFeed_status(feed_status);
        data.setFeed_status_select(feed_status_select);
        data.setGrade(grade);
        data.setGrade_select(grade_select);
        data.setSummarize(Summarize);
        return childInsurRepository.save(data);
    }


    @CrossOrigin
    @GetMapping(value = "/ChildInsurData/Report/{id}")
    public void generateReport(@PathVariable("id") String userId,HttpServletResponse response){
        ReportGenerate reportGenerate = new ReportGenerate(dataBaseConfig);
        pdfPath = reportGenerate.Generate(userId,"chi");
        reportGenerate.download(response,pdfPath);
        logger.info(pdfPath);
    }

}
