package com.sentinel.bank.controller;

import com.sentinel.bank.model.Location;
import com.sentinel.bank.model.Transaction;
import com.sentinel.bank.service.CityService;
import com.sentinel.bank.service.SecurityService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/risk")
@CrossOrigin(origins = "*")
public class RiskController {

    private final SecurityService securityService;
    private final CityService cityService;
    
    // Sayaç: Hangi şehirde olduğumuzu tutar (0 = Rize)
    private int currentIndex = 0; 
    private Transaction lastTransaction;

    public RiskController(SecurityService securityService, CityService cityService) {
        this.securityService = securityService;
        this.cityService = cityService;
        
        // BAŞLANGIÇ: Listenin 0. elemanı (Rize)
        Location startLocation = cityService.getRoute().get(0);
        this.lastTransaction = new Transaction(1, 100.0, System.currentTimeMillis()/1000, startLocation);
        
        System.out.println("Rota Başlatıldı: " + startLocation.getCityName());
    }

    // HTML Sayfası açılınca buraya sorar: "Neredeyiz?"
    @GetMapping("/current-location")
    public Location getCurrentLocation() {
        return cityService.getRoute().get(currentIndex);
    }

    // Butona basınca çalışır: "Sıradaki Şehre Git"
    @PostMapping("/simulate-random")
    public Map<String, Object> simulateNextStep() {
        List<Location> route = cityService.getRoute();
        
        // 1. Sıradaki şehre geç (Modülo % işlemi sayesinde liste bitince 0'a döner)
        int nextIndex = (currentIndex + 1) % route.size();
        Location newLoc = route.get(nextIndex);
        
        // 2. İşlem oluştur
        Transaction currentTransaction = new Transaction(1, 5000, System.currentTimeMillis()/1000, newLoc);

        // 3. Mesafe Kontrolü Yap
        boolean isFraud = securityService.isFraud(lastTransaction, currentTransaction);
        
        Map<String, Object> response = new HashMap<>();
        response.put("city", newLoc.getCityName());
        response.put("lat", newLoc.getLatitude());
        response.put("lon", newLoc.getLongitude());
        response.put("isFraud", isFraud);
        
        String fromCity = route.get(currentIndex).getCityName();
        String toCity = newLoc.getCityName();
        
        if (isFraud) {
            response.put("message", "🚨 ALARM! " + fromCity + " -> " + toCity + " çok uzak!");
        } else {
            response.put("message", "✅ " + toCity + "'e ulaşıldı.");
        }

        // Senaryo gereği her türlü ilerletiyoruz
        lastTransaction = currentTransaction;
        currentIndex = nextIndex; 
        
        return response;
    }
}