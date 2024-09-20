package com.employee.service;

import com.employee.dto.Emp;
import com.employee.dto.EmpListResponse;
import com.employee.dto.EmpResponse;
import com.employee.entity.Employee;
import com.employee.repository.EmployeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

@Autowired
EmployeRepository employeRepository;

    public EmpListResponse getAll(){
        List<Emp> emp = new ArrayList<>();
        List<Employee> employees =  employeRepository.findAll();
        BeanUtils.copyProperties(employees, emp);

        EmpListResponse resp = new EmpListResponse();
        resp.setEmpList(emp);
        resp.setCode(0);
        resp.setDesc("Success");
        return resp;
    }

    public EmpResponse getEmpById(int id){
        EmpResponse resp = new EmpResponse();

        Emp empDto = new Emp();
        Optional<Employee> emp  =  employeRepository.findById(id);
        if(emp.isPresent()) {
            BeanUtils.copyProperties(emp.get(), empDto);

            resp.setEmp(empDto);
            resp.setCode(0);
            resp.setDesc("Success");
        }else {
            resp.setCode(1);
            resp.setDesc("Employee not found");
        }

        return resp;
    }

    public EmpResponse save(Emp emp){
        EmpResponse resp = new EmpResponse();
        Employee e = Employee.builder()
                .id(emp.getId())
                .name(emp.getName())
                .location(emp.getLocation())
                .build();
        Employee employee  =  employeRepository.save(e);

        BeanUtils.copyProperties(employee, emp);

        resp.setEmp(emp);
        resp.setCode(0);
        resp.setDesc("Success");


        return resp;
    }

    public EmpResponse update(Emp emp){
        Optional<Employee> employee = employeRepository.findById(emp.getId());
        EmpResponse resp = new EmpResponse();


        if(employee.isPresent()) {
            employee.get().setName(emp.getName());
            employee.get().setLocation(emp.getLocation());
            BeanUtils.copyProperties(employee.get(), emp);

            resp.setEmp(emp);
            resp.setCode(0);
            resp.setDesc("Success");
        }else {
            resp.setCode(1);
            resp.setDesc("Employee not found");
        }


        return resp;
    }

    public EmpResponse delete(int id){
        employeRepository.deleteById(id);
        EmpResponse resp = new EmpResponse();

        resp.setCode(0);
        resp.setDesc("Success");
        return resp;
    }
}
