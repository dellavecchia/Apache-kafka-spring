package com.dellavecchia.osms.config;

import com.dellavecchia.osms.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;
    @Bean
    public boolean dbInstance() {
        if (ddl.equals("create")) {
            this.dbService.dbInstance();
        }
        return false;
    }
}
