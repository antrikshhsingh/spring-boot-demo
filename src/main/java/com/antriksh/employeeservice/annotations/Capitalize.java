package com.antriksh.employeeservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CapitalizeValidator.class)
@Documented
public @interface Capitalize {
    String message() default "Field must be Capitalize";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
