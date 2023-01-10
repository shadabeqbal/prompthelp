package com.project.one.utils;

import com.project.one.models.exception.ExceptionErrorModel;
import org.springframework.stereotype.Component;

@Component
public class ErrorCodes {
    public final static ExceptionErrorModel USER_REGISTER_ERROR = new ExceptionErrorModel(100,"Error in registering user");
    public final static ExceptionErrorModel EMAIL_EXISTS = new ExceptionErrorModel(101,"Email already exists");

}
