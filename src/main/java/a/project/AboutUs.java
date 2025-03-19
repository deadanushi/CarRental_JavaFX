package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutUs {
    public Scene createAboutUsScene(Stage stage) {
        VBox mainLayout = new VBox();
        mainLayout.setStyle("-fx-background-color: white;"); 

        Menu menu = new Menu(stage);

        HBox layout = new HBox(40); 
        layout.setStyle("-fx-padding: 40;");
        layout.setAlignment(Pos.CENTER);

        VBox imagesBox = new VBox(20);
        imagesBox.setAlignment(Pos.CENTER_LEFT);

        ImageView imageView1 = new ImageView(new Image("https://i.ytimg.com/vi/oBJ-63JLg0k/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLD2cZJ8YjHw7tgZP5632YD_-FHiog"));
        ImageView imageView2 = new ImageView(new Image("https://i.gaw.to/vehicles/photos/06/35/063540_2015_bmw_X5.jpg?640x400"));
        imageView1.setFitWidth(400); 
        imageView1.setPreserveRatio(true);
        imageView2.setFitWidth(400); 
        imageView2.setPreserveRatio(true);

        imagesBox.getChildren().addAll(imageView1, imageView2);

        VBox textBox = new VBox(20);
        textBox.setAlignment(Pos.TOP_LEFT);
        textBox.setPadding(new Insets(0, 20, 0, 0)); 

        Text title = new Text("A BIT \nABOUT US");
        title.setStyle("-fx-font-size: 36; -fx-font-weight: bold; -fx-fill: #0B6836;");

        Text description = new Text(
                "Welcome to CAR RENTAL UNYT! We offer a wide range of premium vehicles for every occasion. "
                        + "Whether you need a car for a business trip, vacation, or special event, we provide reliable "
                        + "and affordable options to meet your needs. With top-notch customer service and a hassle-free booking process, "
                        + "your satisfaction is our priority."
        );
        description.setWrappingWidth(400);
        description.setStyle("-fx-font-size: 18; -fx-fill: #333333;");
        description.setTextAlignment(TextAlignment.LEFT);

        Button exploreButton = new Button("EXPLORE MORE");
        exploreButton.setStyle("-fx-background-color: #003366; -fx-text-fill: white; "
                + "-fx-font-size: 16; -fx-font-weight: bold; "
                + "-fx-padding: 15 30; -fx-background-radius: 10;"); // Dark blue button

        
        exploreButton.setOnAction(e -> {
            AllProductsPage allProducts = new AllProductsPage();
            Scene allProductsScene = allProducts.createAllProductsScene(stage);
            stage.setScene(allProductsScene);
            });

        textBox.getChildren().addAll(title, description, exploreButton);

        HBox.setHgrow(imagesBox, Priority.ALWAYS);
        HBox.setHgrow(textBox, Priority.ALWAYS);

        layout.getChildren().addAll(imagesBox, textBox);

        mainLayout.getChildren().addAll(menu, layout);

        mainLayout.setPadding(new Insets(20));

        return new Scene(mainLayout, 1200, 900); 
    }
}
