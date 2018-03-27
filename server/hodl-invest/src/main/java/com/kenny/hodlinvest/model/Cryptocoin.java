package com.kenny.hodlinvest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cryptocoin {
    @Id
    private String ticker;
    private double price;
    private double marketCap;

    public Cryptocoin(
            @JsonProperty("ticker") String ticker,
            @JsonProperty("price") double price,
            @JsonProperty("marketCap") double marketCap) {
        this.ticker = ticker;
        this.price = price;
        this.marketCap = marketCap;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "Cryptocoin{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                ", marketCap=" + marketCap +
                '}';
    }
}
