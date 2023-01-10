package com.project.one.models.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionErrorModel {
    private Integer errorCode;
    private String errorMessage;
}
