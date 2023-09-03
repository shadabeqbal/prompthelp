package com.project.one.service;

import com.project.one.config.CommonConfiguration;
import com.project.one.domain.User;
import com.project.one.email.EmailService;
import com.project.one.models.request.UserRegisterInput;
import com.project.one.models.response.GlobalResponse;
import com.project.one.models.response.RegisterResponse;
import com.project.one.repository.UserRepository;
import com.project.one.utils.AccountType;
import com.project.one.utils.CommonUtils;
import com.project.one.utils.ErrorCodes;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CommonUtils commonUtils;

    @Autowired
    private CommonConfiguration commonConfiguration;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    private static final Logger errorMessagesLogger = LoggerFactory.getLogger("Error Messages");

    public GlobalResponse registerUser(UserRegisterInput userRegisterInput){
        GlobalResponse globalResponse;
        try{
            Boolean emailValid = commonUtils.EmailFilter(userRegisterInput.getEmail());
            if(!emailValid)
                return new GlobalResponse(false,ErrorCodes.ALLOWED_EMAIL_DOMAIN_NOT_EXIST,HttpStatus.SC_OK,"Allowed Email Domains are: "+String.join(", ",commonConfiguration.getAllowedEmailDomains()));

            String hashPassword = commonUtils.encryptPassword(userRegisterInput.getPassword());
            String key = commonUtils.generateKey(userRegisterInput.getName(),AccountType.CLIENT);
            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            Boolean emailExists = commonUtils.checkUserEmailExists(userRegisterInput.getEmail());
            Boolean mobileExists = commonUtils.checkUserMobileExists(userRegisterInput.getMobile());
            if(mobileExists){
                globalResponse = new GlobalResponse(false,ErrorCodes.MOBILE_EXISTS,HttpStatus.SC_OK,null);
                return globalResponse;
            }
            if(!emailExists) {
                User userTable = new User(key, userRegisterInput.getName(), userRegisterInput.getEmail(), userRegisterInput.getMobile(), hashPassword, AccountType.CLIENT, currentDateTime, currentDateTime);
                userRepository.save(userTable);
                RegisterResponse registerResponse = new RegisterResponse();
                registerResponse.setName(userTable.getName());
                registerResponse.setEmail(userTable.getEmail());
                emailService.sendEmailOnUserRegistration(userRegisterInput);
                globalResponse = new GlobalResponse(true, null, HttpStatus.SC_OK, registerResponse);
            }else{
                globalResponse = new GlobalResponse(false,ErrorCodes.EMAIL_EXISTS,HttpStatus.SC_OK,null);
            }
        }catch(Exception e){
            exceptionLogger.error("There is some error registering user"+e.getLocalizedMessage());
            globalResponse = new GlobalResponse(false, ErrorCodes.ACCOUNT_REGISTRATION_ERROR, HttpStatus.SC_OK,e.getMessage());
        }

        return globalResponse;
    }
}
