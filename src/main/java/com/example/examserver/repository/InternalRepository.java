package com.example.examserver.repository;

import com.example.examserver.domain.InternalData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 17:05
 */
public interface InternalRepository extends JpaRepository<InternalData,Integer> {

}
