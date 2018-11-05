package com.example.examserver.controller;

import com.example.examserver.domain.SurgeryData;
import com.example.examserver.repository.SurgeryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/6 9:13
 */
@RestController
public class SurgeryController {

    private final static Logger logger = LoggerFactory.getLogger(SurgeryController.class);

    @Autowired
    private SurgeryRepository surgeryRepository;

    @CrossOrigin
    @PostMapping(value = "/SurgeryData")
    public SurgeryData SurgeryDataAdd(@RequestParam("userId") String userId,
                                       @RequestParam("empId") String empId,
                                       @RequestParam("bald") String bald,
                                       @RequestParam("bald_select") String bald_select,
                                       @RequestParam("lump") String lump,
                                       @RequestParam("lump_select") String lump_select,
                                       @RequestParam("skin") String skin,
                                       @RequestParam("skin_select") String skin_select,
                                       @RequestParam("phimosis") String phimosis,
                                       @RequestParam("phimosis_select") String phimosis_select,
                                       @RequestParam("piles") String piles,
                                       @RequestParam("piles_select") String piles_select,
                                       @RequestParam("hernia") String hernia,
                                       @RequestParam("hernia_select") String hernia_select,
                                       @RequestParam("varix") String varix,
                                       @RequestParam("varix_select") String varix_select,
                                       @RequestParam("Summarize") String Summarize){
        logger.info("userId:"+userId);
        SurgeryData data = new SurgeryData();
        data.setUserId(userId);
        data.setEmpId(empId);
        data.setBald(bald);
        data.setBald_select(bald_select);
        data.setLump(lump);
        data.setLump_select(lump_select);
        data.setSkin(skin);
        data.setSkin_select(skin_select);
        data.setPhimosis(phimosis);
        data.setPhimosis_select(phimosis_select);
        data.setPiles(piles);
        data.setPiles_select(piles_select);
        data.setHernia(hernia);
        data.setHernia_select(hernia_select);
        data.setVarix(varix);
        data.setVarix_select(varix_select);
        data.setSummarize(Summarize);
        return surgeryRepository.save(data);
    }
}
