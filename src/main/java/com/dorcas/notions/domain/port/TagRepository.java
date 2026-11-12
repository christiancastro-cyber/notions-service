package com.dorcas.notions.domain.port;

import com.dorcas.notions.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    List<Tag> findAll();

    Optional<Tag> findById(Long id);

    Tag save(Tag tag);
}