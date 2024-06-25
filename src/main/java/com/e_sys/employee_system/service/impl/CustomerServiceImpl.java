package com.e_sys.employee_system.service.impl;

import com.e_sys.employee_system.entity.Customer;
import com.e_sys.employee_system.exception.NotFoundException;
import com.e_sys.employee_system.mapper.CustomerMapper;
import com.e_sys.employee_system.model.req.CustomerReqDTO;
import com.e_sys.employee_system.model.resp.CustomerRespDTO;
import com.e_sys.employee_system.repository.CustomerRepository;
import com.e_sys.employee_system.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerRespDTO add(CustomerReqDTO customerReqDTO) {
        Customer customer = customerMapper.toEntity(customerReqDTO);
        return customerMapper.toDTO(customerRepository.save(customer));
    }

    @Override
    public CustomerRespDTO edit(Integer customerId, CustomerReqDTO customerReqDTO) {
        Customer selectedCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("employee not found"));
        selectedCustomer.setId(customerId);
        selectedCustomer.setName(customerReqDTO.getName());
        selectedCustomer.setSurname(customerReqDTO.getSurname());
        selectedCustomer.setEmail(customerReqDTO.getEmail());
        selectedCustomer.setBirthdate(customerReqDTO.getBirthdate());
        selectedCustomer.setCustomerStatus(customerReqDTO.getCustomerStatus());
        return customerMapper.toDTO(customerRepository.save(selectedCustomer));
    }

    @Override
    public void deleteById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<CustomerRespDTO> getAll() {
        return customerRepository.findAll()
                .stream().map(customerMapper::toDTO).toList();
    }

    @Override
    public CustomerRespDTO getById(Integer customerId) {
        return customerRepository.findById(customerId).map(customerMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("customer not found"));
    }
}
