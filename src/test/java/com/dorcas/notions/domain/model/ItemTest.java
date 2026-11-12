package com.dorcas.notions.domain.model;

import com.dorcas.notions.domain.exception.InsufficientStockException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    private Item pearlButtons() {
        return Item.builder()
                .id(1L)
                .reference("BUT-01")
                .name("Botón nácar 15 mm")
                .type(ItemType.BUTTON)
                .unitPrice(0.40)
                .stockUnits(100)
                .supplierId(1L)
                .build();
    }

    @Test
    void sellingReducesTheStockAndReturnsTheSale() {
        Item item = pearlButtons();

        Sale sale = item.sell(10);

        assertThat(item.getStockUnits()).isEqualTo(90);
        assertThat(sale.getUnits()).isEqualTo(10);
        assertThat(sale.getAmount()).isCloseTo(4.0, within(0.001));
        assertThat(sale.getRemainingStock()).isEqualTo(90);
    }

    @Test
    void sellingMoreThanTheStockThrowsAndKeepsTheStock() {
        Item item = pearlButtons();

        assertThatThrownBy(() -> item.sell(500))
                .isInstanceOf(InsufficientStockException.class)
                .hasMessageContaining("BUT-01");

        assertThat(item.getStockUnits()).isEqualTo(100);
    }

    @Test
    void fromFiftyUnitsATenPercentDiscountApplies() {
        Item item = pearlButtons();

        assertThat(item.priceFor(49)).isCloseTo(19.60, within(0.001));
        assertThat(item.priceFor(50)).isCloseTo(18.00, within(0.001));
    }
}