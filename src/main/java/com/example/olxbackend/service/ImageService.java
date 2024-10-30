package com.example.olxbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.olxbackend.entity.Image;
import com.example.olxbackend.repository.ImageRepository;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    // Metoda do dodania zdjęcia do ogłoszenia
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    // Metoda do pobierania zdjęć powiązanych z ogłoszeniem
    public List<Image> findImagesByAd(Long adId) {
        return imageRepository.findByAdAdId(adId);
    }
}
