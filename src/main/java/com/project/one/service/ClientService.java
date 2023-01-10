package com.project.one.service;

import com.google.common.hash.Hashing;
import com.project.one.domain.Client;
import com.project.one.email.EmailService;
import com.project.one.models.request.ClientRegisterInput;
import com.project.one.models.response.GlobalResponse;
import com.project.one.models.response.RegisterResponse;
import com.project.one.repository.ClientRepository;
import com.project.one.utils.AccountType;
import com.project.one.utils.CommonUtils;
import com.project.one.utils.ErrorCodes;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.util.SimpleElementVisitor6;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CommonUtils commonUtils;

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    private static final Logger errorMessagesLogger = LoggerFactory.getLogger("Error Messages");

    public GlobalResponse registerUser(ClientRegisterInput clientRegisterInput){
        GlobalResponse globalResponse;
        try{
            String hashPassword = commonUtils.encryptPassword(clientRegisterInput.getPassword());
            String key = commonUtils.generateKey(clientRegisterInput.getName(),AccountType.CLIENT);
            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            Boolean emailExists = commonUtils.checkUserEmailExists(clientRegisterInput.getEmail());
            if(!emailExists) {
                Client clientTable = new Client(key, clientRegisterInput.getName(), clientRegisterInput.getEmail(), hashPassword, AccountType.CLIENT, currentDateTime, currentDateTime);
                clientRepository.save(clientTable);
                RegisterResponse registerResponse = new RegisterResponse();
                registerResponse.setName(clientTable.getName());
                registerResponse.setEmail(clientTable.getEmail());
                emailService.sendEmailOnUserRegistration(clientRegisterInput);
                globalResponse = new GlobalResponse(true, null, HttpStatus.SC_OK, registerResponse);
            }else{
                globalResponse = new GlobalResponse(false,ErrorCodes.EMAIL_EXISTS,HttpStatus.SC_OK,null);
            }
        }catch(Exception e){
            exceptionLogger.error("There is some error registering user"+e.getLocalizedMessage());
            globalResponse = new GlobalResponse(false, ErrorCodes.USER_REGISTER_ERROR, HttpStatus.SC_OK,null);
        }

        return globalResponse;
    }
}
