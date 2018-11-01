package com.example.examserver.controller;

import com.example.examserver.domain.GeneralData;
import com.example.examserver.ireport.ReportGenerate;
import com.example.examserver.repository.GeneralDataRespository;
import com.example.examserver.utils.DataBaseConfig;
import com.sun.deploy.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class GeneralDataController {

    private final  static Logger logger = LoggerFactory.getLogger(GeneralDataController.class);

    @Autowired
    private GeneralDataRespository generalDataRespository;

    @Autowired
    private DataBaseConfig dataBaseConfig;

    private String pdfPath;

    @CrossOrigin
    @PostMapping(value = "/GeneralData")
    public GeneralData generalDataAdd(@RequestParam("UserId") String userId,
                                      @RequestParam("height") Float height,
                                      @RequestParam("weight") Float weight,
                                      @RequestParam("waistline") Float waistline,
                                      @RequestParam("BMI") Float BMI,
                                      @RequestParam("bloodPressure") Float bloodPressure,
                                      @RequestParam("medicationHis") String medicationHis,
                                      @RequestParam("allergicHis") String allergicHis,
                                      @RequestParam("Summarize") String Summarize){
       GeneralData data = new GeneralData();
       data.setUserId(userId);
       data.setHeight(height);
       data.setWeight(weight);
       data.setWaistline(waistline);
       data.setBMI(BMI);
       data.setBloodPressure(bloodPressure);
       data.setMedicationHis(medicationHis);
       data.setAllergicHis(allergicHis);
       data.setSummarize(Summarize);
        return generalDataRespository.save(data);
    }

    @CrossOrigin
    @GetMapping(value = "/GeneralData/Report/{id}")
    public void generateReport(@PathVariable("id") String userId){
        ReportGenerate reportGenerate = new ReportGenerate(dataBaseConfig);
        pdfPath = reportGenerate.Generate(userId);
        logger.info(pdfPath);
    }


    @CrossOrigin
    @GetMapping(value="/download")
    public void download( HttpServletResponse response){
        //通过文件的保存文件夹路径加上文件的名字来获得文件
        File file=new File(pdfPath);
        //当文件存在
        if(file.exists()){
            //首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
            response.setContentType("application/pdf;charset=UTF-8");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition",String.format("filename=\"%s\"", file.getName()));
            //进行读写操作
            byte[]buffer=new byte[1024];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try{
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                OutputStream os=response.getOutputStream();
                //从源文件中读
                int i=bis.read(buffer);
                while(i!=-1){
                    //写到response的输出流中
                    os.write(buffer,0,i);
                    i=bis.read(buffer);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                //善后工作，关闭各种流
                try {
                    if(bis!=null){
                        bis.close();
                    }
                    if(fis!=null){
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
