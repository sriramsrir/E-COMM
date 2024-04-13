package com.joint.joint.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.joint.joint.Entity.EmpPersonalEntity;


@Repository
public interface EmpPersonalRepo extends JpaRepository<EmpPersonalEntity,Integer>{
  
}