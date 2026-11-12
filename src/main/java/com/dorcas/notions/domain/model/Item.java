package com.dorcas.notions.domain.model;

import com.dorcas.notions.domain.exception.InsufficientStockException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class Item {

    private static final int DISCOUNT_FROM_UNITS = 50;
    private static final double DISCOUNT = 0.10;

    private final Long id;
    private String reference;
    private String name;
    private ItemType type;
    private double unitPrice;
    private int stockUnits;
    private Long supplierId;

    @Builder.Default
    private final Set<Tag> tags = new HashSet<>();

    public double priceFor(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Units must be positive: " + units);
        }
        double price = unitPrice * units;
        return units >= DISCOUNT_FROM_UNITS ? price * (1 - DISCOUNT) : price;
    }

    public Sale sell(int units) {
        double amount = priceFor(units);
        if (units > stockUnits) {
            throw new InsufficientStockException(reference, units, stockUnits);
        }
        stockUnits -= units;
        return Sale.builder()
                .itemId(id)
                .units(units)
                .amount(amount)
                .remainingStock(stockUnits)
                .build();
    }

    public void update(String reference, String name, ItemType type,
                       double unitPrice, int stockUnits, Long supplierId) {
        this.reference = reference;
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
        this.stockUnits = stockUnits;
        this.supplierId = supplierId;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public Set<Tag> getTags() {
        return Set.copyOf(tags);
    }
}