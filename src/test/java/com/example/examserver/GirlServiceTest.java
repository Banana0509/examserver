package com.example.examserver;

import com.example.examserver.domain.Girl;
import com.example.examserver.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //测试环境跑 JUNIT底层
@SpringBootTest  //启动整个spring工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(1);
        Assert.assertEquals( new Integer(9),girl.getAge());
    }
}
