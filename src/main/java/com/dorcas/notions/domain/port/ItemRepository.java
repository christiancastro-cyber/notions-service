package com.dorcas.notions.domain.port;

import com.dorcas.notions.domain.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemRepository {

    PageResult<Item> findAll(ItemType type, PageQuery pageQuery);

    Optional<Item> findById(Long id);

    boolean existsByReference(String reference);

    boolean existsByReferenceInAnotherItem(String reference, Long id);

    Item save(Item item);

    void deleteById(Long id);

    List<Item> findWithStockBelow(int minimum);

    Map<ItemType, Long> totalUnitsByType();

    Sale saveSale(Sale sale);
}