package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage {

    public Scene createHomePage(Stage stage) {
        VBox mainLayout = new VBox(20); // Spacing between elements
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(20));

        Menu menu = new Menu(stage);

        ImageView headerImage = new ImageView(
            new Image("https://www.bmw.com/content/dam/bmw/common/topics/fascination-bmw/bmw-luxury-class/bmw-gklplus-onepager-nightsky-edition-01.jpg")
        );
        headerImage.setFitWidth(1000);
        headerImage.setFitHeight(300);
        headerImage.setPreserveRatio(true);

        Button browseButton = new Button("Browse our shop");
        browseButton.setStyle("-fx-background-color: #0B6836; -fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold; -fx-padding: 10 20; -fx-background-radius: 8;");
        browseButton.setOnAction(e -> {
            AllProductsPage allProducts = new AllProductsPage();
            Scene allProductsScene = allProducts.createAllProductsScene(stage);
            stage.setScene(allProductsScene);
        });

        HBox productSection = new HBox(20); 
        productSection.setAlignment(Pos.CENTER);
        productSection.setPadding(new Insets(30));

        ProductCard productCard = new ProductCard();

        VBox newCollectionCard = createSpecialCard();
        productSection.getChildren().add(newCollectionCard);

        VBox product1 = productCard.createProductCard(
                "https://static.auctionauto.com.ua/images/image.autowini.com/AUTOWINI4/UploadImage/Thumb/202112/21/CI202112210001366994/1640012975844_1024.jpg",
                "Audi A8 3.0 2012",
                100,
                stage,
                300,
                350
        );
        productSection.getChildren().add(product1);

        VBox product2 = productCard.createProductCard(
                "https://i.gaw.to/vehicles/photos/06/35/063540_2015_bmw_X5.jpg?640x400",
                "BMW X5 2015",
                100,
                stage,
                300,
                350
        );
        productSection.getChildren().add(product2);

        mainLayout.getChildren().addAll(menu, headerImage, browseButton, productSection);

        return new Scene(mainLayout, 1000, 800);
    }

    private VBox createSpecialCard() {
        VBox specialCard = new VBox(20);
        specialCard.setAlignment(Pos.CENTER);
        specialCard.setPadding(new Insets(20));
        specialCard.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10; -fx-background-radius: 10; "
                + "-fx-padding: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 5);");
        specialCard.setPrefWidth(250);
        specialCard.setPrefHeight(300);

        Text title = new Text("NEW COLLECTION");
        title.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-fill: #0B6836;");

        Button exploreButton = new Button("EXPLORE");
        exploreButton.setStyle("-fx-background-color: #0B6836; -fx-text-fill: white; -fx-font-size: 14; -fx-font-weight: bold;");
        exploreButton.setOnAction(e -> System.out.println("Explore New Collection Clicked!"));

        specialCard.getChildren().addAll(title, exploreButton);

        return specialCard;
    }
}
