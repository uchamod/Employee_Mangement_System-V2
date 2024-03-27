package com.example.employems.EmployeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpDTO {
    private int empId;
    private String empName;
    private String empAddress;
    private int empMobileNumber;

}
