package com.project.one;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@OpenAPIDefinition(info =
    @Info(title = "Backend",
            version = "1.0.0",
            description="",
            termsOfService = "javaexpress",
            contact = @Contact(name = "Shadab Eqbal", email = "shadabeqbal2008@gmail.com"),
            license = @License(name = "Apache 2.0", url = "javaexpress")
    )
)

public class OneApplication {
    private static final Logger logger = LogManager.getLogger(OneApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OneApplication.class, args);
    }

}
