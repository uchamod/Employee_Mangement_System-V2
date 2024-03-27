package com.example.employems.EmployeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="emplye")
public class Employe {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//this is for genetate id auto
    private int empId;
    private String empName;
    private String empAddress;
    private int empMobileNumber;






}
