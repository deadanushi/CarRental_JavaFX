package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AllProductsPage {

    public Scene createAllProductsScene(Stage stage) {
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setStyle("-fx-background-color: white;");

        Menu menu = new Menu(stage);

        Text title = new Text("All Products");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-fill: #333333;");

        GridPane productGrid = new GridPane();
        productGrid.setPadding(new Insets(20));
        productGrid.setHgap(30); // Horizontal gap between cards
        productGrid.setVgap(30); // Vertical gap between cards
        productGrid.setAlignment(Pos.CENTER);

        ProductCard productCard = new ProductCard();

        VBox product1 = productCard.createProductCard(
                "https://i.ytimg.com/vi/oBJ-63JLg0k/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLD2cZJ8YjHw7tgZP5632YD_-FHiog",
                "Mercedes Benz E 250 2015",
                60.0,
                stage,
                300,
                350
        );
        productGrid.add(product1, 0, 0);

        VBox product2 = productCard.createProductCard(
                "https://images.hgmsites.net/hug/2010-mercedes-benz-c63-amg_100300680_h.jpg",
                "Mercedes Benz C 300 2010",
                40,
                stage,
                300,
                350
        );
        productGrid.add(product2, 1, 0);

        VBox product3 = productCard.createProductCard(
                "https://static.auctionauto.com.ua/images/image.autowini.com/AUTOWINI4/UploadImage/Thumb/202112/21/CI202112210001366994/1640012975844_1024.jpg",
                "Audi A8 3.0 2012",
                100,
                stage,
                300,
                350
        );
        productGrid.add(product3, 2, 0);

        VBox product4 = productCard.createProductCard(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3yS77qmy39SLpt8yFD_A5dPPcLodzQwQGHQ&s",
                "Audi A6 2.0 MANUAL 2016",
                80,
                stage,
                300,
                350
        );
        productGrid.add(product4, 0, 1);

        VBox product5 = productCard.createProductCard(
                "https://i.gaw.to/vehicles/photos/06/35/063540_2015_bmw_X5.jpg?640x400",
                "BMW X5 2015",
                100,
                stage,
                300,
                350
        );
        productGrid.add(product5, 1, 1);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(productGrid);
        scrollPane.setFitToWidth(true); 
        scrollPane.setStyle("-fx-background: white;");
        scrollPane.setPadding(new Insets(20));

        mainLayout.getChildren().addAll(menu, title, scrollPane);

        return new Scene(mainLayout, 1200, 800);
    }
}
