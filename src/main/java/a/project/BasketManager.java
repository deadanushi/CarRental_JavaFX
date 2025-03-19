package a.project;

import java.util.ArrayList;
import java.util.List;

public class BasketManager {
    private static BasketManager instance;
    private final List<BasketItem> basket;

    private BasketManager() {
        basket = new ArrayList<>();
    }

    public static BasketManager getInstance() {
        if (instance == null) {
            instance = new BasketManager();
        }
        return instance;
    }

    public void addItem(String productName, double price) {
        for (BasketItem item : basket) {
            if (item.getName().equals(productName)) {
                item.incrementQuantity();
                return;
            }
        }
        basket.add(new BasketItem(productName, price, 1)); 
    }

    public List<BasketItem> getBasketItems() {
        return basket;
    }

    public double calculateTotal() {
        return basket.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
}

class BasketItem {
    private final String name;
    private final double price;
    private int quantity;

    public BasketItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

