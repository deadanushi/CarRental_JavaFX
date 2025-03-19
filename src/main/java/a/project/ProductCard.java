package a.project;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductCard {

    public VBox createProductCard(String imgURL, String productName, double price, Stage stage, double cardWidth, double cardHeight) {
        VBox card = new VBox(10); 
        card.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10; -fx-background-radius: 10; "
                + "-fx-padding: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);");
        card.setAlignment(Pos.CENTER);
        card.setPrefWidth(cardWidth);
        card.setPrefHeight(cardHeight);

        ImageView productImage = new ImageView();
        Image image = new Image(imgURL); 
        productImage.setImage(image);


        productImage.setFitWidth(cardWidth - 50);
        productImage.setFitHeight(cardHeight / 2);
        productImage.setPreserveRatio(true); 

        Text name = new Text(productName);
        name.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

        Text priceText = new Text("$" + String.format("%.2f", price));
        priceText.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-fill: #0B6836;");

        Button addToBasketButton = new AddToBasketButton(productName, price);

        card.getChildren().addAll(productImage, name, priceText, addToBasketButton);

        return card;
    }
}
