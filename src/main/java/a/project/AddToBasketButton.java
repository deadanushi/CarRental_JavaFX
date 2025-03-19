package a.project;

import javafx.scene.control.Button;

public class AddToBasketButton extends Button {
    public AddToBasketButton(String productName, double price) {
        super("Add to Basket");
        this.setStyle("-fx-background-color: #47672b; -fx-text-fill: white; -fx-padding: 5;");
        this.setOnAction(e -> {
            BasketManager basketManager = BasketManager.getInstance();
            basketManager.addItem(productName, price);
        });
    }
}
