package com.project.one.domain.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.openmbean.OpenMBeanConstructorInfo;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class ObjectConverter implements AttributeConverter<Object,String> {
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    @Override
    public String convertToDatabaseColumn(Object stringList){
        ObjectMapper objectMapper = new ObjectMapper();
        String objectStatsJson = null;
        try{
            if(stringList != null){
                objectStatsJson = objectMapper.writeValueAsString(stringList);
            }
        }catch (final JsonProcessingException e){
            exceptionLogger.error("JSON writing error",e);
        }

        return objectStatsJson;
    }

    @Override
    public Object convertToEntityAttribute(String objectStatsJson){
        ObjectMapper objectMapper = new ObjectMapper();
        Object objectStats = null;
        try{
            if(objectStatsJson != null){
                objectStats = objectMapper.readValue(objectStatsJson, Object.class);
            }
        }catch (final IOException e){
            exceptionLogger.error("JSON reading error", e);
        }

        return objectStats;
    }
}
