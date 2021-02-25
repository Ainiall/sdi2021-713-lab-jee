package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Component
public class TeacherFormValidator implements Validator {

    @Autowired
    private TeachersService teacherService;

    @Override
    public boolean supports(Class<?> clazz) {
	return Teacher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	Teacher teacher = (Teacher) target;
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "Error.empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Error.empty");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "Error.empty");
	// el dni debe tener 9 caracteres y terminar con una letra
	String dni = String.valueOf(teacher.getDNI().charAt(teacher.getDNI().length()-1));
	if (teacher.getDNI().length() != 9 && dni.matches("[a-zA-Z]")) {
	    errors.rejectValue("DNI", "Error.teacher.dni");
	}
	// el dni es unico
	if (teacherService.getTeacherByDNI(teacher.getDNI()) != null) {
	    errors.rejectValue("DNI", "Error.teacher.dni.duplicate");
	}

    }

}
