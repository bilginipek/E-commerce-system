import java.util.List;
import java.util.ArrayList;

abstract class Product {

    protected String id;
    protected String name;
    protected double basePrice;

    public Product(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double calculateFinalPrice();

    public void displayInfo() {
        System.out.println("Product ID:  " +  id +" Name: " + name +" Base Price:  " + basePrice + " TRY");
    }

    public void displayInfo(boolean detailed) {

        if (!detailed) {
            displayInfo();
            return;
        }

        System.out.println("[DETAILED] Product ID: " + id +" Name: " + name +" Base Price: " + basePrice +" Type: " + getClass().getSimpleName());
    }

    public void displayInfo(String currency) {

        double rate;

        switch (currency.toUpperCase()) {
            case "USD": rate = 35; break;
            case "EUR": rate = 38; break;
            case "GBP": rate = 44; break;
            default:
                System.out.println("Unsupported currency!");
                return;
        }

        double fxPrice = basePrice / rate;

        System.out.println("[FX] Product ID: " + id +"Name: " + name +"TRY Price: " + basePrice +" | " + currency + " Price: " +String.format("%.2f", fxPrice));
    }
}



class ElectronicsProduct extends Product {

    private int warrantyMonths;

    public ElectronicsProduct(String id, String name,double basePrice, int warrantyMonths) {
        super(id, name, basePrice);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice * 1.05;
    }

    @Override
    public void displayInfo(boolean detailed) {

        if (!detailed) {
            displayInfo();
            return;
        }

        System.out.println("[DETAILED ELECTRONICS] Product ID: " + id +" Name: " + name +" Base Price: " + basePrice +" Warranty: " + warrantyMonths + " months");
    }
}



class ClothingProduct extends Product {

    private String size;
    private String material;

    public ClothingProduct(String id, String name,double basePrice, String size, String material) {
        super(id, name, basePrice);
        this.size = size;
        this.material = material;
    }

    @Override
    public double calculateFinalPrice() {

        if (material.equalsIgnoreCase("Organic"))
            return basePrice * 0.90;

        return basePrice;
    }

    @Override
    public void displayInfo(boolean detailed) {

        if (!detailed) {
            displayInfo();
            return;
        }

        System.out.println("[DETAILED CLOTHING] Product ID: " + id +" Name: " + name +" Base Price: " + basePrice +" Size: " + size +" Material: " + material);
    }
}



class BookProduct extends Product {

    private String author;

    public BookProduct(String id, String name,double basePrice, String author) {
        super(id, name, basePrice);
        this.author = author;
    }

    @Override
    public double calculateFinalPrice() {
        return basePrice;
    }

    @Override
    public void displayInfo(boolean detailed) {

        if (!detailed) {
            displayInfo();
            return;
        }

        System.out.println("[DETAILED BOOK] Product ID: " + id +" Name: " + name +" Base Price: " + basePrice +" Author: " + author);
    }
}



class Inventory<T extends Product> {

    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public <U extends Product> List<U> filterByType(Class<U> type) {

        List<U> filtered = new ArrayList<>();

        for (T p : products) {
            if (type.isInstance(p)) {
                filtered.add(type.cast(p));
            }
        }
        return filtered;
    }

    public List<T> getAll() {
        return products;
    }
}



public class EcommerceSystem {

    public static void main(String[] args) {

        Inventory<Product> inventory = new Inventory<>();

        Product p1 = new ElectronicsProduct("E1231", "Laptop", 30000, 24);
        Product p2 = new ClothingProduct("C1444", "T-Shirt", 800, "M", "Organic");
        Product p3 = new BookProduct("B9090", "Çizgili Pijamalı Çocuk", 1500, "John Boyne");

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("DISPLAY INFO");
        for (Product p : inventory.getAll()) {
            p.displayInfo(true);
        }

        System.out.println("FINAL PRICES");

        double total = 0;

        for (Product p : inventory.getAll()) {

            double price = p.calculateFinalPrice();

            System.out.println(p.name + " Final Price: " + price);

            total += price;
        }

        System.out.println("TOTAL COST: " + total);

        System.out.println("FILTER: ELECTRONICS ONLY");

        List<ElectronicsProduct> electronics =
                inventory.filterByType(ElectronicsProduct.class);

        for (ElectronicsProduct e : electronics) {
            e.displayInfo(true);
        }

        System.out.println("fx display (usd)");
        p1.displayInfo("usd");
    }
}


