package a.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaymentPage extends BorderPane {

    public PaymentPage(Stage stage) {

        Menu menu = new Menu(stage);
        this.setTop(menu);

        PaymentMethod paymentMethod = new PaymentMethod();

        StackPane cardWrapper = new StackPane();
        cardWrapper.setStyle("-fx-background-color: #dff0d8; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        cardWrapper.setPadding(new Insets(20));
        cardWrapper.getChildren().add(paymentMethod);

        StackPane.setAlignment(paymentMethod, Pos.CENTER);

        VBox centerBox = new VBox(cardWrapper);
        centerBox.setAlignment(Pos.CENTER); 
        centerBox.setPadding(new Insets(20)); 
        this.setCenter(centerBox);
    }
}

class PaymentMethod extends VBox {

    public PaymentMethod() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15); 
        grid.setVgap(15);
        grid.setPadding(new Insets(20));
        Text sceneTitle = new Text("Your Payment Details");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 22));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label nameLabel = new Label("Cardholder Name:");
        grid.add(nameLabel, 0, 1);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 1);
        Label cardLabel = new Label("Card Number:");
        grid.add(cardLabel, 0, 2);
        TextField cardField = new TextField();
        cardField.setPromptText("Enter card number");
        grid.add(cardField, 1, 2);
        Label expDateLabel = new Label("Expiration Date (MM/YY):");
        grid.add(expDateLabel, 0, 3);
        TextField expDateField = new TextField();
        expDateField.setPromptText("MM/YY");
        grid.add(expDateField, 1, 3);
        Label cvvLabel = new Label("CVV:");
        grid.add(cvvLabel, 0, 4);
        TextField cvvField = new TextField();
        cvvField.setPromptText("Enter CVV");
        grid.add(cvvField, 1, 4);

        Button payButton = new Button("Pay Now");
        payButton.setOnAction(e -> handlePayment(nameField.getText(), cardField.getText(), expDateField.getText(), cvvField.getText()));
        grid.add(payButton, 0, 5, 2, 1);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.getChildren().add(grid);
    }

    private void handlePayment(String name, String cardNumber, String expDate, String cvv) {
        if (name.isEmpty() || cardNumber.isEmpty() || expDate.isEmpty() || cvv.isEmpty()) {
            showAlert("Error", "All fields must be filled.");
            return;
        }
        showAlert("Success", "Payment details submitted successfully!");
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

