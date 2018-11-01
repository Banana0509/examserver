package com.example.examserver.controller;

import java.util.List;

import com.example.examserver.domain.Girl;
import com.example.examserver.domain.Result;
import com.example.examserver.exception.GirlException;
import com.example.examserver.repository.GirlRepository;
import com.example.examserver.service.GirlService;
import com.example.examserver.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class GirlController {

    private final  static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     * @return
     */
    @CrossOrigin
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生资料
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @PostMapping(value = "/girlso")
    public Result<Girl> girlAddObj(@Valid  Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //logger.error(bindingResult.getFieldError().getDefaultMessage());
            return null;
            //return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        //girl.setAge(girl.getAge());
        //girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生
    @GetMapping(value= "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    //更新
    @PutMapping(value= "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value= "/girls/{id}")
    public void girlDetele(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getAge(id);
    }

}
