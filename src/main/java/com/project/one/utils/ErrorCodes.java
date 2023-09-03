package com.project.one.utils;

import com.project.one.models.exception.ExceptionErrorModel;
import org.springframework.stereotype.Component;

@Component
public class ErrorCodes {
    public final static ExceptionErrorModel ACCOUNT_REGISTRATION_ERROR = new ExceptionErrorModel(100,"Error in registering to an account");
    public final static ExceptionErrorModel ACCOUNT_LOGIN_ERROR = new ExceptionErrorModel(101,"Error in Login to an account");
    public final static ExceptionErrorModel EMAIL_EXISTS = new ExceptionErrorModel(102,"Email already exists");
    public final static ExceptionErrorModel MOBILE_EXISTS = new ExceptionErrorModel(103,"Mobile already exists");
    public final static ExceptionErrorModel ALLOWED_EMAIL_DOMAIN_NOT_EXIST = new ExceptionErrorModel(104,"Email is not valid");



}
