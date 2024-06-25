package com.e_sys.employee_system.model.req;

import com.e_sys.employee_system.enums.EmployeeStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeReqDTO {

    @NotNull(message = "name can not be null")
    @Size(max = 20)
    String name;

    @NotNull
    @Size(max = 30)
    String surname;

    @NotNull
    @Email
    @Size(min = 8, max = 100)
    String email;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    EmployeeStatus employeeStatus;
}
