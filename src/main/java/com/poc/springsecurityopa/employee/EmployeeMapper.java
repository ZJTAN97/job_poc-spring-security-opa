package com.poc.springsecurityopa.employee;

import com.poc.springsecurityopa.employee.domain.Employee;
import com.poc.springsecurityopa.employee.dto.EmployeeDTO;
import com.poc.springsecurityopa.employee.dto.EmployeeNameDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public abstract class EmployeeMapper {

    @Mapping(target = "employeeName", expression = "java(employeeDTO.getEmployeeName().getFirstName() + \" \" + employeeDTO.getEmployeeName().getLastName()) ")
    abstract Employee toEmployee(EmployeeDTO employeeDTO);

    @InheritInverseConfiguration
    @Mapping(target = "employeeName", qualifiedByName = {"mapToEmployeeName"})
    abstract EmployeeDTO toEmployeeDTO(Employee employee);

    @Named("mapToEmployeeName")
    EmployeeNameDTO mapToEmployeeName(String employeeName) {
        String[] names = employeeName.split(" ");
        return EmployeeNameDTO.builder()
                .firstName(names[0])
                .lastName(names[1])
                .build();
    }

}
