package com.example.examserver.service;

import com.example.examserver.domain.Girl;
import com.example.examserver.enums.ResultEnum;
import com.example.examserver.exception.GirlException;
import com.example.examserver.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional //事务支持
    public void insertTwo(){
        Girl a = new Girl();
        a.setAge(18);
        a.setCupSize("C");
        girlRepository.save(a);

        Girl b = new Girl();
        b.setAge(180);
        b.setCupSize("C");
        girlRepository.save(b);
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            //小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if (age >=10 && age < 16){
            //初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查找一个女性信息   单元测试案例
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
       return girlRepository.findOne(id);
    }
}
