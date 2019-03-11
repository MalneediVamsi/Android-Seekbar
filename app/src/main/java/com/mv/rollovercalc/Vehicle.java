package com.mv.rollovercalc;

public class Vehicle {

    private String type;

    private int minht;

    private int maxht;

    private int minTrack;

    private int maxTrack;

    private double minRollThreshold;

    private double maxRollThreshold;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinht() {
        return minht;
    }

    public void setMinht(int minht) {
        this.minht = minht;
    }

    public int getMaxht() {
        return maxht;
    }

    public void setMaxht(int maxht) {
        this.maxht = maxht;
    }

    public int getMinTrack() {
        return minTrack;
    }

    public void setMinTrack(int minTrack) {
        this.minTrack = minTrack;
    }

    public int getMaxTrack() {
        return maxTrack;
    }

    public void setMaxTrack(int maxTrack) {
        this.maxTrack = maxTrack;
    }

    public double getMinRollThreshold() {
        return minRollThreshold;
    }

    public void setMinRollThreshold(double minRollThreshold) {
        this.minRollThreshold = minRollThreshold;
    }

    public double getMaxRollThreshold() {
        return maxRollThreshold;
    }

    public void setMaxRollThreshold(double maxRollThreshold) {
        this.maxRollThreshold = maxRollThreshold;
    }
}
