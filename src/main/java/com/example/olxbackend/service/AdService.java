package com.example.olxbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.olxbackend.entity.Ad;
import com.example.olxbackend.repository.AdRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    // Metoda do dodawania nowego ogłoszenia
    public Ad createAd(Ad ad) {
        // Tu można dodać dodatkową logikę biznesową
        return adRepository.save(ad);
    }

    // Metoda do wyszukiwania ogłoszeń użytkownika
    public List<Ad> findAdsByUser(Long userId) {
        return adRepository.findByUserUserId(userId);
    }

    // Metoda do znalezienia ogłoszenia po jego ID
    public Optional<Ad> findAdById(Long id) {
        return adRepository.findById(id);
    }

    // Metoda do usuwania ogłoszenia po ID
    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }
}
