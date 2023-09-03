package com.project.one.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterInput {

    private String name;
    private String email;
    private String mobile;
    private String password;

}
