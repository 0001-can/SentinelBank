package com.sentinel.bank.service;

import com.sentinel.bank.model.Location;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    
    // Harita (Map) değil, Sıralı Liste (List) kullanıyoruz
    private final List<Location> journeyRoute = new ArrayList<>();

    public CityService() {
        // --- TÜRKİYE (Başlangıç Rize) ---
        addCity("Rize", 41.0201, 40.5234); // Index 0
        addCity("Istanbul", 41.0082, 28.9784);
        addCity("Ankara", 39.9334, 32.8597);
        addCity("Izmir", 38.4237, 27.1428);
        addCity("Antalya", 36.8969, 30.7133);
        addCity("Trabzon", 41.0028, 39.7167);
        addCity("Bursa", 40.1885, 29.0610);
        addCity("Adana", 37.0000, 35.3213);
        addCity("Gaziantep", 37.0662, 37.3833);
        addCity("Samsun", 41.2867, 36.3300);
        addCity("Erzurum", 39.9043, 41.2679);
        addCity("Van", 38.4891, 43.4089);
        addCity("Diyarbakir", 37.9144, 40.2306);
        addCity("Kayseri", 38.7205, 35.4826);
        addCity("Eskisehir", 39.7667, 30.5256);

        // --- AVRUPA ---
        addCity("Amsterdam", 52.3676, 4.9041);
        addCity("London", 51.5074, -0.1278);
        addCity("Berlin", 52.5200, 13.4050);
        addCity("Paris", 48.8566, 2.3522);
        addCity("Madrid", 40.4168, -3.7038);
        addCity("Rome", 41.9028, 12.4964);
        addCity("Vienna", 48.2082, 16.3738);
        addCity("Athens", 37.9838, 23.7275);
        addCity("Moscow", 55.7558, 37.6173);
        addCity("Kyiv", 50.4501, 30.5234);
        addCity("Oslo", 59.9139, 10.7522);
        addCity("Stockholm", 59.3293, 18.0686);
        addCity("Helsinki", 60.1699, 24.9384);
        addCity("Dublin", 53.3498, -6.2603);
        addCity("Brussels", 50.8503, 4.3517);
        addCity("Zurich", 47.3769, 8.5417);
        addCity("Warsaw", 52.2297, 21.0122);
        addCity("Prague", 50.0755, 14.4378);
        addCity("Lisbon", 38.7223, -9.1393);
        addCity("Barcelona", 41.3851, 2.1734);
        addCity("Budapest", 47.4979, 19.0402);
        addCity("Munich", 48.1351, 11.5820);

        // --- KUZEY AMERİKA ---
        addCity("New York", 40.7128, -74.0060);
        addCity("Los Angeles", 34.0522, -118.2437);
        addCity("Chicago", 41.8781, -87.6298);
        addCity("San Francisco", 37.7749, -122.4194);
        addCity("Toronto", 43.6510, -79.3470);
        addCity("Vancouver", 49.2827, -123.1207);
        addCity("Mexico City", 19.4326, -99.1332);
        addCity("Miami", 25.7617, -80.1918);
        addCity("Las Vegas", 36.1699, -115.1398);
        addCity("Houston", 29.7604, -95.3698);
        addCity("Boston", 42.3601, -71.0589);
        addCity("Seattle", 47.6062, -122.3321);
        addCity("Washington DC", 38.9072, -77.0369);
        addCity("Montreal", 45.5017, -73.5673);

        // --- GÜNEY AMERİKA ---
        addCity("Sao Paulo", -23.5505, -46.6333);
        addCity("Buenos Aires", -34.6037, -58.3816);
        addCity("Rio de Janeiro", -22.9068, -43.1729);
        addCity("Lima", -12.0464, -77.0428);
        addCity("Bogota", 4.7110, -74.0721);
        addCity("Santiago", -33.4489, -70.6693);
        addCity("Caracas", 10.4806, -66.9036);

        // --- ASYA & ORTA DOĞU ---
        addCity("Tokyo", 35.6762, 139.6503);
        addCity("Beijing", 39.9042, 116.4074);
        addCity("Shanghai", 31.2304, 121.4737);
        addCity("Seoul", 37.5665, 126.9780);
        addCity("Mumbai", 19.0760, 72.8777);
        addCity("Delhi", 28.6139, 77.2090);
        addCity("Bangkok", 13.7563, 100.5018);
        addCity("Singapore", 1.3521, 103.8198);
        addCity("Dubai", 25.2048, 55.2708);
        addCity("Jakarta", -6.2088, 106.8456);
        addCity("Hong Kong", 22.3193, 114.1694);
        addCity("Kuala Lumpur", 3.1390, 101.6869);
        addCity("Tehran", 35.6892, 51.3890);
        addCity("Riyadh", 24.7136, 46.6753);
        addCity("Tel Aviv", 32.0853, 34.7818);
        addCity("Baku", 40.4093, 49.8671);

        // --- AFRİKA ---
        addCity("Cairo", 30.0444, 31.2357);
        addCity("Johannesburg", -26.2041, 28.0473);
        addCity("Lagos", 6.5244, 3.3792);
        addCity("Nairobi", -1.2921, 36.8219);
        addCity("Cape Town", -33.9249, 18.4241);
        addCity("Casablanca", 33.5731, -7.5898);

        // --- OKYANUSYA ---
        addCity("Sydney", -33.8688, 151.2093);
        addCity("Melbourne", -37.8136, 144.9631);
        addCity("Auckland", -36.8485, 174.7633);
    }

    // Listeye ekleme yapan yardımcı metot
    private void addCity(String name, double lat, double lon) {
        journeyRoute.add(new Location(lat, lon, name));
    }

    // Sıralı listeyi dışarıya verir
    public List<Location> getRoute() {
        return journeyRoute;
    }
}