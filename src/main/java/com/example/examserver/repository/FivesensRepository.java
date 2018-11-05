package com.example.examserver.repository;

import com.example.examserver.domain.FivesensData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: pengnana0509@163.com
 * @data: 2018/11/5 17:06
 */
public interface FivesensRepository extends JpaRepository<FivesensData,Integer> {
}
