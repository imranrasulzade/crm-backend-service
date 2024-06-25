package com.e_sys.employee_system.mapper;

import com.e_sys.employee_system.entity.Employee;
import com.e_sys.employee_system.model.req.EmployeeReqDTO;
import com.e_sys.employee_system.model.resp.EmployeeRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeReqDTO employeeReqDTO);

    EmployeeRespDTO toDTO(Employee employee);

}
