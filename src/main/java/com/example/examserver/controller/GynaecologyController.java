package com.example.examserver.controller;

import com.example.examserver.domain.GynaecologyData;
import com.example.examserver.repository.GynaecologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/6 9:22
 */
@RestController
public class GynaecologyController {

    private final static Logger logger = LoggerFactory.getLogger(GynaecologyController.class);

    @Autowired
    private GynaecologyRepository gynaecologyRepository;

    @CrossOrigin
    @PostMapping(value = "/GynaecologyData")
    public GynaecologyData GynaecologyDataAdd(@RequestParam("userId") String userId,
                                          @RequestParam("empId") String empId,
                                          @RequestParam("lump") String lump,
                                          @RequestParam("lump_select") String lump_select,
                                          @RequestParam("skin") String skin,
                                          @RequestParam("skin_select") String skin_select,
                                          @RequestParam("breast") String breast,
                                          @RequestParam("breast_select") String breast_select,
                                          @RequestParam("hernia") String hernia,
                                          @RequestParam("hernia_select") String hernia_select,
                                          @RequestParam("varix") String varix,
                                          @RequestParam("varix_select") String varix_select,
                                          @RequestParam("Summarize") String Summarize){
        logger.info("userId:"+userId);
        GynaecologyData data = new GynaecologyData();
        data.setUserId(userId);
        data.setEmpId(empId);
        data.setLump(lump);
        data.setLump_select(lump_select);
        data.setSkin(skin);
        data.setSkin_select(skin_select);
        data.setBreast(breast);
        data.setBreast_select(breast_select);
        data.setHernia(hernia);
        data.setHernia_select(hernia_select);
        data.setVarix(varix);
        data.setVarix_select(varix_select);
        data.setSummarize(Summarize);
        return gynaecologyRepository.save(data);
    }
}
