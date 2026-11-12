package com.dorcas.notions.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter //Un getX() por cada campo (isX() si es boolean)
@Builder //Item.builder().name("…").stockUnits(100).build()
@AllArgsConstructor // Constructor con todos los campos
public class Supplier {

    private final Long id;
    private final String name;
    private final ContactCard contact;
}
