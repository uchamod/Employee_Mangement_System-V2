package com.example.employems.EmployeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component

public class ResponseDTO {
    private String code;
    private String massage;
    private Object content;


}
