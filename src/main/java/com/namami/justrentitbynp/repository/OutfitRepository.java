package com.namami.justrentitbynp.repository;

import com.namami.justrentitbynp.entity.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {
}