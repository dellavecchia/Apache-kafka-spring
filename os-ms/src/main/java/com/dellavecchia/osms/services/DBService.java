package com.dellavecchia.osms.services;

import com.dellavecchia.osms.domain.Client;
import com.dellavecchia.osms.domain.OS;
import com.dellavecchia.osms.domain.Technic;
import com.dellavecchia.osms.domain.enums.Priority;
import com.dellavecchia.osms.domain.enums.Status;
import com.dellavecchia.osms.repositories.ClientRepository;
import com.dellavecchia.osms.repositories.OSRepository;
import com.dellavecchia.osms.repositories.TechnicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TechnicRepository technicRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OSRepository osRepository;

    public void dbInstance(){

        Technic t1 = new Technic(null, "Gabriel Guimarães", "100.531.916-25", "+5535991481551");
        Technic t2 = new Technic(null, "Marcio Mascarenas", "412.205.966-63", "+5519986545454");
        Client c1 = new Client(null, "Ivonir Della Vecchia Marques", "161.684.882-00", "(35) 99120-3731");
        OS os1 = new OS(null, "test create os", Priority.HIGH, Status.ONGOING, t1, c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        technicRepository.saveAll(Arrays.asList(t1, t2));
        clientRepository.saveAll(Arrays.asList(c1));
        osRepository.saveAll(Arrays.asList(os1));
    }
}
