package com.cognizant.truyum.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.truyum.model.MenuItemForm;

import org.springframework.stereotype.Component;


@Component
public class CustomValidator implements Validator {

	public void validate(Object arg0, Errors arg1) {
		MenuItemForm reg = (MenuItemForm) arg0;

		
	}

	public boolean supports(Class<?> arg0) {

		return MenuItemForm.class.isAssignableFrom(arg0);
	}

}
