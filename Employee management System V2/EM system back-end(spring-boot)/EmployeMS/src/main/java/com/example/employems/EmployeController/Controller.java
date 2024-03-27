package com.example.employems.EmployeController;

import com.example.employems.EmployeDTO.EmpDTO;
import com.example.employems.EmployeDTO.ResponseDTO;
import com.example.employems.EmployeService.EmpServices;
import com.example.employems.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/Controller")//contrller path
@RestController
@CrossOrigin

public class Controller {
    //autowired service and responseDTO classes
    @Autowired
    private EmpServices service;

    @Autowired
    private ResponseDTO responseDTO;

    //controller method for save the data refering employeeId
    @PostMapping("/saveById")
    public ResponseEntity saveDataById(@RequestBody EmpDTO dto){


        try {
            String response=service.saveById(dto); //get the response from service(saveByid) method

            if(response.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS); //set the code
                responseDTO.setMassage("Data saved succsessfuly"); //set the response massage
                responseDTO.setContent(dto); //set the response content(we resend dto object)
                return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);// return the responseDTO and httpstatus as aresponseEntity

            } else if (response.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMassage("Data already saved");
                responseDTO.setContent(dto);
                return new ResponseEntity(responseDTO,HttpStatus.ALREADY_REPORTED);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMassage("Request failed");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Unexpected error; "+e);
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //controller method for updata the data refering employeeId
    @PutMapping("/updateById")
    public ResponseEntity updateDataById(@RequestBody EmpDTO dto){


        try {
            String response=service.updateById(dto); //get the response from service(saveByid) method

            if(response.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS); //set the code
                responseDTO.setMassage("Data updated succsessfuly"); //set the response massage
                responseDTO.setContent(dto); //set the response content(we resend dto object)
                return new ResponseEntity(responseDTO,HttpStatus.ACCEPTED);// return the responseDTO and httpstatus as aresponseEntity

            } else if (response.equals("01")) {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMassage("Data not found");
                responseDTO.setContent(dto);
                return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND);

            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMassage("Request failed");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Unexpected error; "+e);
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //controller method for getall the data from table
    @GetMapping("/getAllData")
    public ResponseEntity getData() {

        try {
            List<EmpDTO> allData = service.getAllData();
            responseDTO.setCode(VarList.RSP_SUCCESS); //set the code
            responseDTO.setMassage("Data fetched succsessfuly"); //set the response massage
            responseDTO.setContent(allData); //set the response content(we resend dto object)
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Unexpected error; " + e);
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    //controller method for get the data refering employeeId
    @GetMapping("/getDataById/{id}")
    public ResponseEntity getDataById(@PathVariable int id) {

        try {
            EmpDTO empData = service.searchData(id);
            if (empData != null) {

                responseDTO.setCode(VarList.RSP_SUCCESS); //set the code
                responseDTO.setMassage("Data fetched succsessfuly"); //set the response massage
                responseDTO.setContent(empData); //set the response content(we resend dto object)
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMassage("Data not found");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.NOT_FOUND);
            }


        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Unexpected error; " + e);
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //controller method for delete the data refering employeeId
        @DeleteMapping("/deleteDataById/{id}")
        public ResponseEntity deleteDataById(@PathVariable int id){

            try{
                String data=service.deleteData(id);
                if(data.equals(VarList.RSP_SUCCESS)){

                    responseDTO.setCode(VarList.RSP_SUCCESS); //set the code
                    responseDTO.setMassage("Data deleted succsessfuly"); //set the response massage
                    responseDTO.setContent(null); //set the response content(we resend dto object)
                    return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

                }else if(data.equals(VarList.RSP_NO_DATA_FOUND)){
                    responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                    responseDTO.setMassage("Data not found");
                    responseDTO.setContent(null);
                    return new ResponseEntity(responseDTO,HttpStatus.NOT_FOUND);

                }else{
                    responseDTO.setCode(VarList.RSP_FAIL);
                    responseDTO.setMassage("Request failed");
                    responseDTO.setContent(null);
                    return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
                }


            }catch (Exception e){
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMassage("Unexpected error; " + e);
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }





}
