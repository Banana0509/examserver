package com.example.examserver.repository;


import com.example.examserver.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository  extends JpaRepository<Girl,Integer> {

    //通过年龄来查询 函数明明严格规则
    public List<Girl> findByAge(Integer age);
}
