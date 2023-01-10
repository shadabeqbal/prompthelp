package com.project.one.domain.converters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class StringListConverter implements AttributeConverter<Set<String>,String> {
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    @Override
    public String convertToDatabaseColumn(Set<String> stringList){
        if(stringList != null)
            return stringList.toString();
        else
            return null;
    }

    @Override
    public Set<String> convertToEntityAttribute(String jsonString){
        Set<String> stringSet = new HashSet<>();
        try{
            if(jsonString != null){
                jsonString = jsonString.replace('[',' ').trim();
                jsonString = jsonString.replace(']',' ').trim();
                jsonString = jsonString.replaceAll(" ","").trim();
                stringSet = new HashSet<>(Arrays.asList(jsonString.split(",")));
            }
        }catch (Exception e){
            exceptionLogger.error("JSON reading error", e);
        }

        return stringSet;
    }
}
