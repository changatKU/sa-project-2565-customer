package ku.cs;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "SA-PROJECT", 1200, 700);

        configRoute();
        FXRouter.goTo("login");
    }

    public void configRoute(){
        String packageStr = "ku/cs/";
        FXRouter.when("home", packageStr + "home.fxml");
        FXRouter.when("register", packageStr + "register.fxml");
        FXRouter.when("login", packageStr + "login.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}