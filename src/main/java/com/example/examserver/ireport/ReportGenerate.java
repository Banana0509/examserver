package com.example.examserver.ireport;

import com.example.examserver.utils.DataBaseConfig;
import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerate {

    private final  static Logger logger = LoggerFactory.getLogger(ReportGenerate.class);

    private  DataBaseConfig dataBaseConfig;

    public ReportGenerate(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig =dataBaseConfig;
    }

    public  String  Generate(String id){
        ClassLoader classLoader = getClass().getClassLoader();
        URL urltpl = classLoader.getResource("tpl.jasper");
        String reportModelFile= urltpl.getFile().substring(1);
        String pdfPath = urltpl.getFile().substring(1,reportModelFile.length()-10)+"/report.pdf";

        logger.info(pdfPath +","+ reportModelFile);
        Map mapParam= new HashMap();
        mapParam.put("user_id_p",id);
        Connection conn = null;
        try{
            //logger.info(dataBaseConfig.getUrl()+","+dataBaseConfig.getDriver());

            Class.forName(dataBaseConfig.getDriver());
            conn = DriverManager.getConnection(dataBaseConfig.getUrl(),dataBaseConfig.getUsername(),dataBaseConfig.getPassword());
            logger.info(dataBaseConfig.getUrl()+','+dataBaseConfig.getUsername()+','+dataBaseConfig.getPassword());

            byte[] bytes = JasperRunManager.runReportToPdf(reportModelFile,mapParam,conn); //生成pdf文件流
            FileOutputStream output = new FileOutputStream(pdfPath);//生成pdf输入
            output.write(bytes,0,bytes.length);//pdf文件流写入
            output.flush();
            output.close();
        }catch (JRException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                return  pdfPath;
            }catch (SQLException e){
                e.printStackTrace();
                return  "";
            }
        }
    }
}
