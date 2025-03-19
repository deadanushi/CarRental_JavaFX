package a.project;

//Group: Deada, Antonio, Roland, Dariel
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        LogInOrRegister loginRegister = new LogInOrRegister();

        Scene loginScene = loginRegister.createLoginRegisterScene(stage);
        stage.setScene(loginScene);
        stage.setTitle("CAR RENTAL APPLICATION");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
