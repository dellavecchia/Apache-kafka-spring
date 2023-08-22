package com.dellavecchia.osms.services;

import com.dellavecchia.osms.domain.Person;
import com.dellavecchia.osms.domain.Technic;
import com.dellavecchia.osms.dtos.TechnicDTO;
import com.dellavecchia.osms.repositories.PersonRepository;
import com.dellavecchia.osms.repositories.TechnicRepository;
import com.dellavecchia.osms.services.exceptions.DataIntegrityViolationException;
import com.dellavecchia.osms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicService {

    @Autowired
    private TechnicRepository technicRepository;
    @Autowired
    private PersonRepository personRepository;
    public Technic findById(Integer id){
        Optional<Technic> obj = technicRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", type: " + Technic.class.getName())
        );

    }

    public List<Technic> findAll() {
        return technicRepository.findAll();
    }


    public Technic create(TechnicDTO objDTO){
        if (findByCPF(objDTO) != null){
            throw new DataIntegrityViolationException("This CPF already exists in the database!");
        }
        return technicRepository.save(new Technic(null,
                objDTO.getName(), objDTO.getCpf(), objDTO.getPhone()));
    }


    public Technic update(Integer id, TechnicDTO objDTO) {
        Technic oldObj = findById(id);
        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
            throw new DataIntegrityViolationException("This CPF already exists in the database!");
        }
        oldObj.setName(objDTO.getName());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setPhone(objDTO.getPhone());

        return technicRepository.save(oldObj);


    }
    public void delete(Integer id) {
       Technic obj = findById(id);
       if (obj.getList().size() > 0) {
           throw new DataIntegrityViolationException("Existing service orders are bind with this technic, cannot be deleted");
       }
        technicRepository.deleteById(id);


    }

    private Person findByCPF(TechnicDTO objDTO) {
        Person obj = personRepository.findByCPF(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }


}
