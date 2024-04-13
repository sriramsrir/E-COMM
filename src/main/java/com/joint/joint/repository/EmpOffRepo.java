package com.joint.joint.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joint.joint.Entity.EmployeeOffEntity;

@Repository
public interface EmpOffRepo extends JpaRepository<EmployeeOffEntity,Integer>{
@Query("select e from EmployeeOffEntity e join e.per")
	List<EmployeeOffEntity> getDataUsingJoinQuery();
@Query("select e from EmployeeOffEntity e where e.per.id=:id")
	EmployeeOffEntity getEmpByPerid(int id);
	
}