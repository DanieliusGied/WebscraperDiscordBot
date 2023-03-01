package me.dangdrt.webscraper;

public class Item {
    private String name;
    private double price;
    private String pricePer;

    public Item(String name, double price, String pricePer) {
        this.name = name;
        this.price = price;
        this.pricePer = pricePer;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPricePer() {
        return pricePer;
    }
}
