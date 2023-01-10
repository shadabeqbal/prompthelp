package com.project.one.utils;

import com.google.common.hash.Hashing;
import com.project.one.domain.Client;
import com.project.one.repository.ClientRepository;
import com.project.one.repository.PhysicianRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class CommonUtils {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");

    public String encryptPassword(String password){
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    public String generateKey(String name,AccountType accountType){
        String[] tempName = name.split(" ",2);
        Random rnd = new Random();
        int randomNum = Math.abs(rnd.nextInt());
        return accountType.toString()+"__"+tempName[0]+"__"+randomNum;
    }

    public Boolean checkUserEmailExists(String email){
        try{
            Client clientDetails = clientRepository.userEmailExists(email);
            if(clientDetails == null)
                return false;
            else
                return true;
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return false;
        }
    }

    public Boolean checkUserMobileExists(String mobile){
        try{
            Client clientDetails = clientRepository.userMobileExists(mobile);
            if(clientDetails == null)
                return false;
            else
                return true;
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return false;
        }
    }
}
