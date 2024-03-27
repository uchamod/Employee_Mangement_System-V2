package com.example.employems.EmployeService;

import com.example.employems.EmployeDTO.EmpDTO;
import com.example.employems.EmployeEntity.Employe;
import com.example.employems.Util.VarList;
import com.example.employems.EmployeRepostory.EmpRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
//service layer is the layer that use to implement busness logics
public class EmpServices {

    @Autowired
    private EmpRepo repo;


    @Autowired
    private ModelMapper modelMapper;

    //data is saved by using employee id
    public String saveById(EmpDTO dto){

        if(repo.existsById(dto.getEmpId())){ //check the id is already exist in given number
            return VarList.RSP_DUPLICATED;

        }else{
           repo.save(modelMapper.map(dto, Employe.class));
           return VarList.RSP_SUCCESS;
        }
    }

    //current data is updated by giving id row
    public String updateById(EmpDTO dto) {

        if (repo.existsById(dto.getEmpId())) { //check the id is already exist in given number
            repo.save(modelMapper.map(dto, Employe.class));
            return VarList.RSP_SUCCESS;


        } else {
           return VarList.RSP_NO_DATA_FOUND;
        }
    }

    //get all the data from te table
    public ArrayList<EmpDTO> getAllData() {
            ArrayList<Employe> employes=new ArrayList<>(repo.findAll());
            ArrayList<EmpDTO> empDTOS=new ArrayList<>();
            //return modelMapper.map(employes,empDTOS.getClass());
            return modelMapper.map(employes,new TypeToken<ArrayList<EmpDTO>>(){}.getType());

    }

    //search the data from the table according to given employee id
    public EmpDTO searchData(int empId){

        if(repo.existsById(empId)){
            Employe empData = repo.findById(empId).orElse(null);

            return modelMapper.map(empData,EmpDTO.class);
        }else{
            return null;
        }
    }

    //delete the data from the table according to given employee id
    public String  deleteData(int empId){

        if(repo.existsById(empId)){
            repo.deleteById(empId);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


}
