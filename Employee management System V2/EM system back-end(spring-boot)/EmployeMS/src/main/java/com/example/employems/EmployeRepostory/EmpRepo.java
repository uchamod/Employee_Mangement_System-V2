package com.example.employems.EmployeRepostory;

import com.example.employems.EmployeEntity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employe,Integer> {



}
