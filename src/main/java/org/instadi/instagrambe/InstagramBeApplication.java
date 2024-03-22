package org.instadi.instagrambe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class InstagramBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstagramBeApplication.class, args);
    }

}
