package com.bt.ms.im.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.ms.im.entity.GetResponse;

@Repository
public interface DataRepository extends JpaRepository<GetResponse, Long> {

    boolean existsByUuid(String uuid);

    boolean existsByCfsid(String cfsid);
    
}	
