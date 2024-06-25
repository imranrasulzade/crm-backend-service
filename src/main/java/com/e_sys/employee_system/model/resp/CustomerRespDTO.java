package com.e_sys.employee_system.model.resp;

import com.e_sys.employee_system.enums.CustomerStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRespDTO {
    Integer id;
    String name;
    String surname;
    String email;
    LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    CustomerStatus customerStatus;
}
