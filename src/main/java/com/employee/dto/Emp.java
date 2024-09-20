package com.employee.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Emp {

    private int id;
    private String name;
    private String location;


}
