package com.project.one.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "commonconfig")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CommonConfiguration {
    private List<String> allowedEmailDomains;
}
