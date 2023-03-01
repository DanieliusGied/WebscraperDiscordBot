package me.dangdrt.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;


public class Webscraper {

    public static void scrape(String urlBarbora) {
        try {
            final Document document = Jsoup.connect(urlBarbora).get();

            for (Element row : document.select("div.b-product--wrap2.b-product--desktop-grid")) {
                    
                final String name = row
                        .select("div.b-product--wrap.clearfix.b-product--js-hook   ")
                        .select("div.b-product-wrap-img")
                        .select("a.b-product-title.b-product-title--desktop.b-link--product-info")
                        .select("span").text();

                final String priceString = row
                        .select("div.b-product--wrap.clearfix.b-product--js-hook   ")
                        .select(":not(div.b-product-prices-block--loyalty)").first()
                        .select("div.b-product-price-current")
                        .select("span")
                        .text();

                final String pricePer = row
                        .select("div.b-product--wrap.clearfix.b-product--js-hook   ")
                        .select("div.b-product-price--extra")
                        .text();
                    
                final double price = !priceString.equals("") ? Double.parseDouble(priceString.substring(1).replace(',', '.')) : 0;

                logItem(name, price, pricePer);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void logItem(String name, double price, String pricePer){
        Item item = new Item(name, price, pricePer);

        System.out.println("Created item with name " + item.getName() + ", price of " + item.getPrice() + "eur, and price per unit of " + item.getPricePer());
        
        //// TODO: 3/1/2023 add the item to the database 
    }
}
