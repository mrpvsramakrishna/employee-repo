package com.employee.controller;

import com.employee.dto.Emp;
import com.employee.dto.EmpListResponse;
import com.employee.dto.EmpResponse;
import com.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping
    public Mono<ResponseEntity<EmpListResponse>> getAll(){
        return Mono.fromCallable(() -> {
                    return ResponseEntity.status(HttpStatus.OK).body(empService.getAll());
                })
                .subscribeOn(Schedulers.boundedElastic());

    }

    @GetMapping("/:id")
    public Mono<ResponseEntity<EmpResponse>> getById(@PathVariable("id") int id){
        return Mono.fromCallable(() -> {
                    return ResponseEntity.status(HttpStatus.OK).body(empService.getEmpById(id));
                })
                .subscribeOn(Schedulers.boundedElastic());

    }

    @PostMapping
    public Mono<ResponseEntity<EmpResponse>> saveEmp(@RequestBody Emp emp){
        return Mono.fromCallable(() -> {
                    return ResponseEntity.status(HttpStatus.OK).body(empService.save(emp));
                })
                .subscribeOn(Schedulers.boundedElastic());

    }
    @PutMapping
    public Mono<ResponseEntity<EmpResponse>> updateEmp(@RequestBody Emp emp){
        return Mono.fromCallable(() -> {
                    return ResponseEntity.status(HttpStatus.OK).body(empService.update(emp));
                })
                .subscribeOn(Schedulers.boundedElastic());

    }


    @PutMapping("/:id")
    public Mono<ResponseEntity<EmpResponse>> delete(@PathVariable("id") int id){
        return Mono.fromCallable(() -> {
                    return ResponseEntity.status(HttpStatus.OK).body(empService.delete(id));
                })
                .subscribeOn(Schedulers.boundedElastic());

    }
}
