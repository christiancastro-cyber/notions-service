package com.dorcas.notions.domain.model;

import lombok.Builder;
import lombok.Value;

@Value //Clase inmutable - Valores que no cambian. Es casi lo mismo que un record
@Builder //Item.builder().name("…").stockUnits(100).build()
public class Sale {
    Long id;
    Long itemId;
    int units;
    double amount;
    int remainingStock;
}
