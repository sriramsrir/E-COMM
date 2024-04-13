package com.joint.joint.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.joint.joint.Entity.EmployeeOffEntity;
import com.joint.joint.repository.EmpOffRepo;

import jakarta.transaction.Transactional;

@Service
public class EmpService {
@Autowired
EmpOffRepo eor;
	public List<EmployeeOffEntity> insertEmployee(List<EmployeeOffEntity> emplist) {
		return eor.saveAll(emplist);
	}
   
	@Transactional
	public List<EmployeeOffEntity> getDataUsingJoin() {
		return eor.getDataUsingJoinQuery();
	}
	@Transactional
	public EmployeeOffEntity getEmpByEmpPerId(int id) {
		return eor.getEmpByPerid(id);
	}
    public String deleteUser(int id) {
        boolean userExists = eor.existsById(id);
        if (userExists) {
            eor.deleteById(id);
            return "User deleted successfully!";
        }
        return "Record not found with id" + id;
    }
    public Page<EmployeeOffEntity> getPageData(int PageNumber,int PageSize){
        Pageable pageable = PageRequest.of(PageNumber,PageSize,Sort.Direction.ASC,"name");
        return eor.findAll(pageable);
        
    }

    public EmployeeOffEntity updateUser(int Id, EmployeeOffEntity user) {
        Optional<EmployeeOffEntity> userExists = eor.findById(Id);
        if (userExists.isPresent()) {
            EmployeeOffEntity existingUser = userExists.get();
            existingUser.setName(user.getName());
            existingUser.setSalary(user.getSalary());
            return eor.save(existingUser);
        }
        return new EmployeeOffEntity();
    }

}