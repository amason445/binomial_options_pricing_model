package com.amason445;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TickerManager {

    Properties tickerFeatures = new Properties();
    String tickerName;

    public TickerManager(String tickerName) {
        this.tickerName = tickerName;
    }

    public void fillProperties() {
        try (InputStream input = TickerManager.class.getClassLoader().getResourceAsStream(tickerName + ".properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + tickerName + ".properties in project resources");
                return;
            }
            tickerFeatures.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public double getSpotPrice() {
        return getDoubleProperty("ticker.spot");
    }

    public double getStrikePrice() {
        return getDoubleProperty("ticker.strike");
    }

    public double getSigma() {
        return getDoubleProperty("ticker.sigma");
    }

    private double getDoubleProperty(String key) {
        String value = tickerFeatures.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Property " + key + " not found in the properties file.");
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for " + key + ": " + value);
        }
    }
}