package com.project.one.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterInput {

    private String name;
    private String email;
    private String password;

}
