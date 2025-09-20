package com.parinitha.fit.validators;

import java.util.Arrays;
import java.util.List;

import annotations.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (password == null || password.isBlank()) {
			return false;
		}

		if (password.length() < 8) {
			return false;
		}

		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		if (!password.matches(".*[a-z].*")) {
			return false;
		}

		if (!password.matches(".*\\d.*")) {
			return false;
		}

		if (!password.matches(".*[@#$%^&+=!].*")) {
			return false;
		}

		return true;
	}

}
