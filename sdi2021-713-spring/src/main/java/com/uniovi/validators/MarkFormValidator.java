package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;

@Component
public class MarkFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Mark.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	Mark mark = (Mark) target;

	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score",
		"Error.empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
		"Error.empty");
	// la nota desde estar entre 0 y 10
	if (mark.getScore() <= 0 || mark.getScore() >= 10) {
	    errors.rejectValue("score", "Error.mark.score");
	}
	// la descripcion debe tener como minimo 20 caracteres
	if (mark.getDescription().length() < 20) {
	    errors.rejectValue("description", "Error.mark.description");
	}

    }

}
