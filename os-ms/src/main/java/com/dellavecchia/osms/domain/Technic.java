package com.dellavecchia.osms.domain;

import lombok.experimental.SuperBuilder;


public class Technic extends Person {
    public Technic(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
