package org.ownant.owner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class OwnerServiceApplication {
    public static void main(String[] args) {
        SpringApplication userServiceApplication = new SpringApplication(OwnerServiceApplication.class);
        userServiceApplication.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        userServiceApplication.run(args);
    }
}
