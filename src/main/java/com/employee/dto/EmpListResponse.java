package com.employee.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmpListResponse extends  DefaultResponse {

    private List<Emp> empList;

}
