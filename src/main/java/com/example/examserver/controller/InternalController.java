package com.example.examserver.controller;

import com.example.examserver.domain.ChildInsurData;
import com.example.examserver.domain.InternalData;
import com.example.examserver.repository.InternalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 17:10
 */
@RestController
public class InternalController {

    private final  static Logger logger = LoggerFactory.getLogger(InternalController.class);

    @Autowired
    private InternalRepository internalRepository;

    @CrossOrigin
    @PostMapping(value = "/InternalData")
    public InternalData InternalDataAdd(@RequestParam("userId") String userId,
                                        @RequestParam("empId") String empId,
                                        @RequestParam("Hypertension") String Hypertension,
                                        @RequestParam("Hypertension_select") String Hypertension_select,
                                        @RequestParam("HeartDisease") String HeartDisease,
                                        @RequestParam("HeartDisease_select") String HeartDisease_select,
                                        @RequestParam("CerebralInfraction") String CerebralInfraction,
                                        @RequestParam("CerebralInfraction_select") String CerebralInfraction_select,
                                        @RequestParam("Diabetes") String Diabetes,
                                        @RequestParam("Diabetes_select") String Diabetes_select,
                                        @RequestParam("Tumor") String Tumor,
                                        @RequestParam("Tumor_select") String Tumor_select,
                                        @RequestParam("Summarize") String Summarize){
        logger.info("userId:"+userId);
        InternalData data = new InternalData();
        data.setUserId(userId);
        data.setEmpId(empId);
        data.setHypertension(Hypertension);
        data.setHypertension_select(Hypertension_select);
        data.setHeartDisease(HeartDisease);
        data.setHeartDisease_select(HeartDisease_select);
        data.setCerebralInfraction(CerebralInfraction);
        data.setCerebralInfraction_select(CerebralInfraction_select);
        data.setDiabetes(Diabetes);
        data.setDiabetes_select(Diabetes_select);
        data.setTumor(Tumor);
        data.setTumor_select(Tumor_select);
        data.setSummarize(Summarize);
        return internalRepository.save(data);
    }

}
