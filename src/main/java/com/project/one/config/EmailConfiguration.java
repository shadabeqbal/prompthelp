package com.project.one.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration("emailconfig")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmailConfiguration {
    private String adminEmail;
    private String infoEmail;
    private String contactEmail;
    private String noReplyEmail;
    private String promotionsEmail;
}
