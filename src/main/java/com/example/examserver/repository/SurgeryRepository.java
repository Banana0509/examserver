package com.example.examserver.repository;

import com.example.examserver.domain.SurgeryData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 17:07
 */
public interface SurgeryRepository extends JpaRepository<SurgeryData,Integer> {
}
