package com.namami.justrentitbynp.service;

import com.namami.justrentitbynp.entity.Outfit;
import com.namami.justrentitbynp.repository.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutfitService {

    @Autowired
    private OutfitRepository outfitRepository;

    public Outfit saveOutfit(Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    public List<Outfit> getAllOutfits() {
        return outfitRepository.findAll();
    }
}