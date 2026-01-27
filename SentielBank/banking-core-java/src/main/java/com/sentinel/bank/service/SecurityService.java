package com.sentinel.bank.service;

import com.sentinel.bank.model.Location;
import com.sentinel.bank.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    
    // Uçak hızı sınırı (800 km/s)
    private static final double MAX_SPEED_KMH = 800.0; 

    public boolean isFraud(Transaction last, Transaction current) {
        double distance = calculateHaversine(last.getLocation(), current.getLocation());
        double timeDiffHours = (current.getTimestamp() - last.getTimestamp()) / 3600.0;

        // Eğer zaman farkı çok azsa (örn: 1 saniye) ve mesafe varsa -> FRAUD
        if (timeDiffHours < 0.001 && distance > 10) return true;

        double speed = distance / timeDiffHours;
        System.out.println("Hız Hesaplandı: " + speed + " km/h (" + last.getLocation().getCityName() + " -> " + current.getLocation().getCityName() + ")");
        
        return speed > MAX_SPEED_KMH;
    }

    private double calculateHaversine(Location loc1, Location loc2) {
        final int R = 6371; // Dünya Yarıçapı (km)
        double latDist = Math.toRadians(loc2.getLatitude() - loc1.getLatitude());
        double lonDist = Math.toRadians(loc2.getLongitude() - loc1.getLongitude());
        double a = Math.sin(latDist/2) * Math.sin(latDist/2) +
                   Math.cos(Math.toRadians(loc1.getLatitude())) * Math.cos(Math.toRadians(loc2.getLatitude())) *
                   Math.sin(lonDist/2) * Math.sin(lonDist/2);
        return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    }
}