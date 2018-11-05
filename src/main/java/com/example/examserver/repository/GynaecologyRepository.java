package com.example.examserver.repository;

import com.example.examserver.domain.GynaecologyData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 17:08
 */
public interface GynaecologyRepository extends JpaRepository<GynaecologyData,Integer> {
}
