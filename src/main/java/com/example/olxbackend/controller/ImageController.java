package com.example.olxbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.olxbackend.entity.Image;
import com.example.olxbackend.service.ImageService;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    // Endpoint do dodania zdjęcia do ogłoszenia (POST /images)
    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        Image newImage = imageService.addImage(image);
        return ResponseEntity.ok(newImage);
    }

    // Endpoint do pobierania zdjęć powiązanych z ogłoszeniem (GET /images/ad/{adId})
    @GetMapping("/ad/{adId}")
    public ResponseEntity<List<Image>> getImagesByAd(@PathVariable Long adId) {
        List<Image> images = imageService.findImagesByAd(adId);
        return ResponseEntity.ok(images);
    }
}
