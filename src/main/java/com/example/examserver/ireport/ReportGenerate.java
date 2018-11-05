package com.example.examserver.ireport;

import com.example.examserver.utils.DataBaseConfig;
import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    /**
     * 生成报表文件
     * @param id  用户id
     * @param tplName 报表模板名称 tpl chi
     * @return 生成报表路径
     */
    public  String  Generate(String id,String tplName){
        ClassLoader classLoader = getClass().getClassLoader();
        URL urltpl = classLoader.getResource(tplName+".jasper");
        String reportModelFile= urltpl.getFile().substring(1);
        String pdfPath = urltpl.getFile().substring(1,reportModelFile.length()-10)+"/"+tplName+".pdf";

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

    /**
     * 读取pdf文件生成文件流
     * @param response
     * @param pdfPath pdf文件路径
     */
    public void download(HttpServletResponse response, String pdfPath){
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
