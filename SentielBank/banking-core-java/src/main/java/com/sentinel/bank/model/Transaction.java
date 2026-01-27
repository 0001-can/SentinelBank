package com.sentinel.bank.model;

public class Transaction {
    private int userId;
    private double amount;
    private long timestamp;
    private Location location;

    public Transaction(int userId, double amount, long timestamp, Location location) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
    }

    public long getTimestamp() { return timestamp; }
    public Location getLocation() { return location; }
    public double getAmount() { return amount; }
}