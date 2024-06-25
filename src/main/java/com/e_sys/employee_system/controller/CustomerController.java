package com.e_sys.employee_system.controller;

import com.e_sys.employee_system.model.req.CustomerReqDTO;
import com.e_sys.employee_system.model.resp.CustomerRespDTO;
import com.e_sys.employee_system.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v${ApiVersion}/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/new")
    public ResponseEntity<CustomerRespDTO> add(@RequestBody @Valid CustomerReqDTO customerReqDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.add(customerReqDTO));
    }

    @PutMapping("/edit/{customerId}")
    public ResponseEntity<CustomerRespDTO> edit(@PathVariable Integer customerId,
                                                @RequestBody @Valid CustomerReqDTO customerReqDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.edit(customerId, customerReqDTO));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer customerId) {
        customerService.deleteById(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerRespDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }

    @GetMapping("/view/{customerId}")
    public ResponseEntity<CustomerRespDTO> getById(@PathVariable Integer customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(customerId));
    }
}
