package com.example.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.examserver.domain.ChildInsurData;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 10:10
 */
public interface ChildInsurRepository  extends JpaRepository<ChildInsurData,Integer> {
}
