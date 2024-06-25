package com.e_sys.employee_system.service;

import com.e_sys.employee_system.model.req.CustomerReqDTO;
import com.e_sys.employee_system.model.resp.CustomerRespDTO;

import java.util.List;

public interface CustomerService {
    CustomerRespDTO add(CustomerReqDTO customerReqDto);

    CustomerRespDTO edit(Integer customerId, CustomerReqDTO customerReqDto);

    void deleteById(Integer customerId);

    List<CustomerRespDTO> getAll();

    CustomerRespDTO getById(Integer customerId);
}
