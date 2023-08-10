package com.dellavecchia.osms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Person {

    private Integer id;
    private String name;
    private String cpf;

    private String phone;
}
