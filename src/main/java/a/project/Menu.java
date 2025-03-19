package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends VBox {
    private Stage stage;

    public Menu(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage cannot be null");
        }
        this.stage = stage;

        Label nameLabel = new Label("CAR RENTAL UNYT");
        nameLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #47672b;");

        Button homeButton = new Button("Home");
        Button aboutButton = new Button("About Us");
        Button productsButton = new Button("All Products");
        Button basketButton = new Button("Basket");
        Button logoutButton = new Button("Logout");

        String buttonStyle = "-fx-background-color: transparent; -fx-font-size: 14px; -fx-cursor: hand;";
        homeButton.setStyle(buttonStyle);
        aboutButton.setStyle(buttonStyle);
        productsButton.setStyle(buttonStyle);
        basketButton.setStyle("-fx-background-color: #47672b; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        logoutButton.setStyle(buttonStyle);

        homeButton.setOnAction(e -> {
            HomePage homePage = new HomePage();
            Scene homeScene = homePage.createHomePage(stage);
            stage.setScene(homeScene);
        });

        aboutButton.setOnAction(e -> {
            AboutUs aboutUs = new AboutUs();
            Scene aboutScene = aboutUs.createAboutUsScene(stage);
            stage.setScene(aboutScene);
        });

        productsButton.setOnAction(e -> {
            AllProductsPage allProducts = new AllProductsPage();
            Scene allProductsScene = allProducts.createAllProductsScene(stage);
            stage.setScene(allProductsScene);
        });

        basketButton.setOnAction(e -> {
    BasketPage basketPage = new BasketPage(stage); 
    Scene basketScene = new Scene(basketPage, 800, 600); 
    stage.setScene(basketScene); 
});



        logoutButton.setOnAction(e -> {
            LogInOrRegister loginPage = new LogInOrRegister();
            Scene loginScene = loginPage.createLoginRegisterScene(stage);
            stage.setScene(loginScene);
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox menuBar = new HBox(20, nameLabel, spacer, homeButton, aboutButton, productsButton, basketButton, logoutButton);
        menuBar.setAlignment(Pos.CENTER_LEFT);
        menuBar.setPadding(new Insets(10));
        menuBar.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-border-width: 0 0 1 0;");

        this.getChildren().add(menuBar);
        this.setPadding(new Insets(10));
        this.setSpacing(10);
    }
}
