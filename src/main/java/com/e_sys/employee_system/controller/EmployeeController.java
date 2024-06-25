package com.e_sys.employee_system.controller;

import com.e_sys.employee_system.model.req.EmployeeReqDTO;
import com.e_sys.employee_system.model.resp.EmployeeRespDTO;
import com.e_sys.employee_system.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v${ApiVersion}/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity<EmployeeRespDTO> add(@RequestBody @Valid EmployeeReqDTO employeeReqDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.add(employeeReqDTO));
    }

    @PutMapping("/edit/{employeeId}")
    public ResponseEntity<EmployeeRespDTO> edit(@PathVariable Integer employeeId,
                                         @RequestBody @Valid EmployeeReqDTO employeeReqDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.edit(employeeId, employeeReqDTO));
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeRespDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping("/view/{employeeId}")
    public ResponseEntity<EmployeeRespDTO> getById(@PathVariable Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(employeeId));
    }
}
