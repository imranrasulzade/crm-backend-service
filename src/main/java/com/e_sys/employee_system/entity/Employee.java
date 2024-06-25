package com.e_sys.employee_system.entity;

import com.e_sys.employee_system.enums.EmployeeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @NotNull
    @Column(name = "name")
    @Size(max = 20)
    String name;

    @NotNull
    @Column(name = "surname")
    @Size(max = 30)
    String surname;

    @NotNull
    @Email
    @Size(min = 8, max = 100)
    @Column(name = "email")
    String email;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthdate")
    LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    EmployeeStatus employeeStatus;

}
