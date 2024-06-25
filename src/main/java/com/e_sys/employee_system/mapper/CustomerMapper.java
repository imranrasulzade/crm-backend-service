package com.e_sys.employee_system.mapper;

import com.e_sys.employee_system.entity.Customer;
import com.e_sys.employee_system.model.req.CustomerReqDTO;
import com.e_sys.employee_system.model.resp.CustomerRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerReqDTO customerReqDto);

    CustomerRespDTO toDTO(Customer customer);

}
