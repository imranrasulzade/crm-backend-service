package com.e_sys.employee_system.service;

import com.e_sys.employee_system.model.req.EmployeeReqDTO;
import com.e_sys.employee_system.model.resp.EmployeeRespDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeRespDTO add(EmployeeReqDTO employeeReqDTO);

    EmployeeRespDTO edit(Integer employeeId, EmployeeReqDTO employeeReqDTO);

    void deleteById(Integer employeeId);

    List<EmployeeRespDTO> getAll();

    EmployeeRespDTO getById(Integer employeeId);
}
