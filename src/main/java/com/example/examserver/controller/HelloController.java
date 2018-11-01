package com.example.examserver.controller;

import com.example.examserver.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/hello")
@RestController
public class HelloController {

    //@Value("${cupSize}")
    //private String cupSize;
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value={"/{id}/say","/hi/{id}"},method= RequestMethod.GET)//  /8888/say
    public String say(@PathVariable("id") Integer id){
        return "hello Spring boot！" +",id:"+id+girlProperties.getCupSize();
        //return "index";
    }

    //@RequestMapping(value="/sayHello",method= RequestMethod.GET) //?id=8888
    @GetMapping(value="/sayHello")
    public String sayHello(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "hello Spring boot！" +",id:"+myId;
        //return "index";
    }


}
