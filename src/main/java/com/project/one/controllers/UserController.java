package com.project.one.controllers;

import com.project.one.models.request.UserRegisterInput;
import com.project.one.models.response.GlobalResponse;
import com.project.one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterInput userRegisterInput) {
        GlobalResponse globalResponse = userService.registerUser(userRegisterInput);
        return ResponseEntity.status(globalResponse.getStatusCode()).body(globalResponse);
    }
}
