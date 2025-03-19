package a.project;

import java.io.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInOrRegister {
    private static final String File_Name = "users.txt";

    public Scene createLoginRegisterScene(Stage stage) {
        VBox mainContainer = new VBox(15);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setStyle("-fx-padding: 20; -fx-background-color: #f5f5f5; -fx-font-size: 14px;");

        Label lblTitle = new Label("Welcome");
        lblTitle.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("USERNAME");
        tfUsername.setStyle("-fx-padding: 10; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        PasswordField pfPassword = new PasswordField();
        pfPassword.setPromptText("PASSWORD");
        pfPassword.setStyle("-fx-padding: 10; -fx-border-color: #cccccc; -fx-border-radius: 5; -fx-background-radius: 5;");

        Button btnLogin = new Button("Login");
        btnLogin.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 5; -fx-cursor: hand;");

        Button btnRegister = new Button("Register");
        btnRegister.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 10 20; -fx-background-radius: 5; -fx-cursor: hand;");

        Label lblMessage = new Label();
        lblMessage.setStyle("-fx-text-fill: red;");

        btnLogin.setOnAction(e -> {
            String username = tfUsername.getText(); 
            String password = pfPassword.getText();
            try {
                if (validateLogin(username, password)) {
                    Scene homePageScene = new HomePage().createHomePage(stage); 
                    stage.setScene(homePageScene); 
                } else {
                    lblMessage.setText("Invalid username or password");
                    lblMessage.setStyle("-fx-text-fill: red;");
                }
            } catch (IOException ex) {
                lblMessage.setText("An error occurred while processing your request.");
                lblMessage.setStyle("-fx-text-fill: red;");
            }
        });

        btnRegister.setOnAction(e -> {
            String username = tfUsername.getText();
            String password = pfPassword.getText();
            if (username.isEmpty() || password.isEmpty()) {
                lblMessage.setText("Username and password should not be empty");
                lblMessage.setStyle("-fx-text-fill: red;");
                return;
            }
            try {
                if (isUsernameTaken(username)) {
                    lblMessage.setText("Username is taken");
                    lblMessage.setStyle("-fx-text-fill: red;");
                } else {
                    saveUserToFile(username, password);
                    lblMessage.setText("Registration successful");
                    lblMessage.setStyle("-fx-text-fill: green;");
                }
            } catch (IOException ex) {
                lblMessage.setText("An error occurred while processing your request.");
                lblMessage.setStyle("-fx-text-fill: red;");
            }
        });

        mainContainer.getChildren().addAll(lblTitle, tfUsername, pfPassword, btnLogin, btnRegister, lblMessage);

        return new Scene(mainContainer, 400, 400);
    }

    private boolean validateLogin(String username, String password) throws IOException {
        File file = new File(File_Name);
        if (!file.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isUsernameTaken(String username) throws IOException {
        File file = new File(File_Name);
        if (!file.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveUserToFile(String username, String password) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File_Name, true))) {
            bw.write(username + "," + password);
            bw.newLine();
        }
    }
}
