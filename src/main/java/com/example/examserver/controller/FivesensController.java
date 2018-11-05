package com.example.examserver.controller;

import com.example.examserver.domain.FivesensData;
import com.example.examserver.repository.FivesensRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/6 9:07
 */
@RestController
public class FivesensController {

    private final static Logger logger = LoggerFactory.getLogger(FivesensController.class);

    @Autowired
    private FivesensRepository fivesensRepository;

    @CrossOrigin
    @PostMapping(value = "/FivesensData")
    public FivesensData FivesensDataAdd(@RequestParam("userId") String userId,
                                        @RequestParam("empId") String empId,
                                        @RequestParam("hearing") String hearing,
                                        @RequestParam("hearing_select") String hearing_select,
                                        @RequestParam("vision") String vision,
                                        @RequestParam("vision_select") String vision_select,
                                        @RequestParam("mouth") String mouth,
                                        @RequestParam("mouth_select") String mouth_select,
                                        @RequestParam("Summarize") String Summarize) {
        logger.info("userId:" + userId);
        FivesensData data = new FivesensData();
        data.setUserId(userId);
        data.setEmpId(empId);
        data.setHearing(hearing);
        data.setHearing_select(hearing_select);
        data.setVision(vision);
        data.setVision_select(vision_select);
        data.setMouth(mouth);
        data.setMouth_select(mouth_select);
        data.setSummarize(Summarize);
        return fivesensRepository.save(data);
    }
}
