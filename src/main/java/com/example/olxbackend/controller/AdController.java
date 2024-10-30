package com.example.olxbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.olxbackend.entity.Ad;
import com.example.olxbackend.service.AdService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ads")
public class AdController {

    @Autowired
    private AdService adService;

    // Endpoint do dodawania nowego ogłoszenia (POST /ads)
    @PostMapping
    public ResponseEntity<Ad> createAd(@RequestBody Ad ad) {
        Ad newAd = adService.createAd(ad);
        return ResponseEntity.ok(newAd);
    }

    // Endpoint do pobierania ogłoszeń użytkownika (GET /ads/user/{userId})
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ad>> getAdsByUser(@PathVariable Long userId) {
        List<Ad> ads = adService.findAdsByUser(userId);
        return ResponseEntity.ok(ads);
    }

    // Endpoint do pobierania ogłoszenia po ID (GET /ads/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable Long id) {
        Optional<Ad> ad = adService.findAdById(id);
        return ad.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint do usuwania ogłoszenia po ID (DELETE /ads/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
        return ResponseEntity.noContent().build();
    }
}
