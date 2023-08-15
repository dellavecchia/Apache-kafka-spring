package com.dellavecchia.osms;

import com.dellavecchia.osms.domain.Client;
import com.dellavecchia.osms.domain.OS;
import com.dellavecchia.osms.domain.Technic;
import com.dellavecchia.osms.domain.enums.Priority;
import com.dellavecchia.osms.domain.enums.Status;
import com.dellavecchia.osms.repositories.ClientRepository;
import com.dellavecchia.osms.repositories.OSRepository;
import com.dellavecchia.osms.repositories.TechnicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OsMsApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(OsMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
