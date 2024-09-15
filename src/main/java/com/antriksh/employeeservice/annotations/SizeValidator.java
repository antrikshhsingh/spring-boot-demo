package com.antriksh.employeeservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.concurrent.ConcurrentHashMap;

public class SizeValidator implements ConstraintValidator<Size, String> {

    private int min;
    private int max;
    @Override

    public void initialize(Size size) {
        this.min = size.min();
        this.max = size.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.length() >= min && value.length() <= max;
    }
}
