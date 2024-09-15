package com.antriksh.employeeservice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CapitalizeValidator implements ConstraintValidator<Capitalize,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.trim().matches("^[A-Z].*$");
        
    }
}
