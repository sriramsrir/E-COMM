package com.joint.joint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.joint.joint.Entity.EmployeeOffEntity;
import com.joint.joint.service.EmpService;



@RestController
public class EmployeeController {
@Autowired
EmpService es;
@PostMapping("/insert")
public List<EmployeeOffEntity> createEmployee(@RequestBody List<EmployeeOffEntity> emplist){
	return es.insertEmployee(emplist);
}
@GetMapping("/viewUsingJoin")
public List<EmployeeOffEntity> getData(){
	return es.getDataUsingJoin();
}


@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            return new ResponseEntity<>(es.deleteUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
        }
    }

	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody EmployeeOffEntity user) {
        try {
            return new ResponseEntity<>(es.updateUser(id, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
        }
    }
@GetMapping("viewByEmpPer/{id}")
public EmployeeOffEntity getByEmpPer(@PathVariable int id) {
	return es.getEmpByEmpPerId(id);
}

@GetMapping("/user/{PageNumber}/{PageSize}")
public Page<EmployeeOffEntity> getAllUsers(@PathVariable int PageNumber,@PathVariable int PageSize)
{
    return es.getPageData(PageNumber,PageSize);
}

}