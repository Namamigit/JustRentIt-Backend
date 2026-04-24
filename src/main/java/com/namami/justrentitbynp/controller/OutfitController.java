package com.namami.justrentitbynp.controller;

import com.namami.justrentitbynp.entity.Outfit;
import com.namami.justrentitbynp.service.OutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outfits")

@CrossOrigin(origins = "*")

public class OutfitController {

    @Autowired
    private OutfitService outfitService;

    @PostMapping
    public Outfit createOutfit(@RequestBody Outfit outfit) {
        return outfitService.saveOutfit(outfit);
    }

    @GetMapping
    public List<Outfit> getAllOutfits() {
        return outfitService.getAllOutfits();
    }
}