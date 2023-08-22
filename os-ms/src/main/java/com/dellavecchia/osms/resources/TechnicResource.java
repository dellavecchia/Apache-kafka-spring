package com.dellavecchia.osms.resources;

import com.dellavecchia.osms.domain.Technic;
import com.dellavecchia.osms.dtos.TechnicDTO;
import com.dellavecchia.osms.services.TechnicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technic")
public class TechnicResource {

    @Autowired
    private TechnicService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicDTO> findById(@PathVariable Integer id){
        Technic obj = service.findById(id);
        TechnicDTO objDTO = new TechnicDTO(obj);
        return ResponseEntity.ok().body(objDTO);

    }
    @GetMapping
    public ResponseEntity<List<TechnicDTO>> findAll(){
        List<TechnicDTO> listDTO = service.findAll().stream().map(obj -> new TechnicDTO(obj))
                .collect(Collectors.toList());


//        List<Technic> list = service.findAll();
//        List<TechnicDTO> listDTO = new ArrayList<>();
//        for (Technic obj: list) {
//            listDTO.add(new TechnicDTO(obj));
//        }
//        list.forEach(obj -> listDTO.add(new TechnicDTO(obj)));

        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<TechnicDTO> create(@Valid @RequestBody TechnicDTO objDTO){
        Technic newObj = service.create(objDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TechnicDTO> update(@PathVariable Integer id, @Valid @RequestBody TechnicDTO objDTO){
        TechnicDTO newObj = new TechnicDTO(service.update(id, objDTO));

        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
