package com.example.examserver.repository;

import com.example.examserver.domain.GeneralData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralDataRespository extends  JpaRepository<GeneralData,Integer> {

}
