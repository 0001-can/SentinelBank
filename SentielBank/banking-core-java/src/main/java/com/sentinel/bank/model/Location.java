package com.sentinel.bank.model;

public class Location {
    private double latitude;
    private double longitude;
    private String cityName;

    public Location(double lat, double lon, String city) {
        this.latitude = lat;
        this.longitude = lon;
        this.cityName = city;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getCityName() { return cityName; }
}