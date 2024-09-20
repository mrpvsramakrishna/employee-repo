package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table
@Builder
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
}
