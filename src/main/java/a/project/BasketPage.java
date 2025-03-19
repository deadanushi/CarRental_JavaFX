package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BasketPage extends BorderPane {

    public BasketPage(Stage stage) {
        Menu menu = new Menu(stage);
        VBox topBox = new VBox(menu); 
        topBox.setPadding(new Insets(10));
        this.setTop(topBox);

        VBox titleBox = new VBox(5);
        Label title = new Label("Basket");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
        Label itemCount = new Label(BasketManager.getInstance().getBasketItems().size() + " items");
        itemCount.setStyle("-fx-font-size: 16px; -fx-text-fill: #666666;");
        titleBox.getChildren().addAll(title, itemCount);
        titleBox.setAlignment(Pos.CENTER_LEFT);
        titleBox.setPadding(new Insets(20, 0, 10, 20));

        VBox basketItemsContainer = new VBox(15);
        basketItemsContainer.setPadding(new Insets(20));
        basketItemsContainer.setStyle("-fx-background-color: #f9f9f9; -fx-border-radius: 10; -fx-padding: 15;");
        basketItemsContainer.setPrefWidth(500);

        BasketManager basketManager = BasketManager.getInstance();
        for (BasketItem item : basketManager.getBasketItems()) {
            HBox itemRow = createBasketItem(item);
            basketItemsContainer.getChildren().add(itemRow);
        }

        VBox orderSummary = new VBox(15);
        orderSummary.setPadding(new Insets(20));
        orderSummary.setStyle("-fx-background-color: #f9f9f9; -fx-border-radius: 10; -fx-padding: 15;");
        orderSummary.setPrefWidth(300);

        Label orderSummaryTitle = new Label("Order Summary");
        orderSummaryTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        HBox subtotalRow = createSummaryRow("Subtotal", String.format("$%.2f", basketManager.calculateTotal()));
        HBox shippingRow = createSummaryRow("Shipping", "$3.99");
        HBox totalRow = createSummaryRow("Total", String.format("$%.2f", basketManager.calculateTotal() + 3.99));
        totalRow.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button continueButton = new Button("Continue to payment");
continueButton.setStyle("-fx-background-color: #0B6836; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10;");
continueButton.setPrefWidth(200);
continueButton.setOnAction(e -> {
    PaymentPage paymentPage = new PaymentPage(stage); 
    Scene paymentScene = new Scene(paymentPage, 1000, 800); 
    stage.setScene(paymentScene); 
});


        orderSummary.getChildren().addAll(orderSummaryTitle, subtotalRow, shippingRow, totalRow, continueButton);

        HBox content = new HBox(20);
        content.getChildren().addAll(basketItemsContainer, orderSummary);
        content.setPadding(new Insets(20));
        content.setAlignment(Pos.TOP_LEFT);

        this.setTop(topBox); 
        this.setCenter(content); 
    }

    private HBox createBasketItem(BasketItem item) {
        HBox itemRow = new HBox(20);
        itemRow.setPadding(new Insets(10));
        itemRow.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10; -fx-padding: 10; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 5);");
        itemRow.setAlignment(Pos.CENTER_LEFT);

        VBox productDetails = new VBox(5);
        Label name = new Label(item.getName());
        name.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label price = new Label(String.format("$%.2f", item.getPrice() * item.getQuantity()));
        price.setStyle("-fx-font-size: 14px; -fx-text-fill: #0B6836;");

        Label weight = new Label("Qty: " + item.getQuantity());
        weight.setStyle("-fx-font-size: 14px; -fx-text-fill: #666666;");

        productDetails.getChildren().addAll(name, price, weight);

        itemRow.getChildren().addAll(productDetails);
        return itemRow;
    }

    private HBox createSummaryRow(String label, String value) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER_LEFT);

        Label labelText = new Label(label);
        labelText.setStyle("-fx-font-size: 14px; -fx-text-fill: #666666;");

        Label valueText = new Label(value);
        valueText.setStyle("-fx-font-size: 14px; -fx-text-fill: #333333;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        row.getChildren().addAll(labelText, spacer, valueText);
        return row;
    }
}
