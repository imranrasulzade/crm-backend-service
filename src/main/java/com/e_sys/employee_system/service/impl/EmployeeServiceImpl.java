package com.e_sys.employee_system.service.impl;

import com.e_sys.employee_system.entity.Employee;
import com.e_sys.employee_system.exception.NotFoundException;
import com.e_sys.employee_system.mapper.EmployeeMapper;
import com.e_sys.employee_system.model.req.EmployeeReqDTO;
import com.e_sys.employee_system.model.resp.EmployeeRespDTO;
import com.e_sys.employee_system.repository.EmployeeRepository;
import com.e_sys.employee_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeRespDTO add(EmployeeReqDTO employeeReqDTO) {
        Employee employee = employeeMapper.toEntity(employeeReqDTO);
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeRespDTO edit(Integer employeeId, EmployeeReqDTO employeeReqDTO) {
        Employee selectedEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("employee not found"));
        selectedEmployee.setId(employeeId);
        selectedEmployee.setName(employeeReqDTO.getName());
        selectedEmployee.setSurname(employeeReqDTO.getSurname());
        selectedEmployee.setEmail(employeeReqDTO.getEmail());
        selectedEmployee.setBirthdate(employeeReqDTO.getBirthdate());
        selectedEmployee.setEmployeeStatus(employeeReqDTO.getEmployeeStatus());
        return employeeMapper.toDTO(employeeRepository.save(selectedEmployee));
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeRespDTO> getAll() {
        return employeeRepository.findAll()
                .stream().map(employeeMapper::toDTO).toList();
    }

    @Override
    public EmployeeRespDTO getById(Integer employeeId) {
        return employeeRepository.findById(employeeId).map(employeeMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("employee not found"));
    }
}
