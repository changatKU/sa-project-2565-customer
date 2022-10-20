package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.services.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController{
    @FXML
    TextField usernameTF, passwordTF;

    @FXML
    Label messageLB;

    public void handleLoginButton() throws Exception {
        String username = "\"" + usernameTF.getText() + "\"";
        String password;
        String command = "SELECT Username, Password FROM Customer" +
                " WHERE Username = " + username;
        System.out.println(command);
        ResultSet result = DBConnector.query(command);
        result.next();
        System.out.println(result.getString("Password"));
        password = result.getString("Password");
        if(!password.equals(passwordTF.getText())){
            messageLB.setText("Username or Password is Incorrect");
        }else{
            messageLB.setText("Welcome " + usernameTF.getText());
        }
    }

    public void handleRegisterButton() throws Exception {
        FXRouter.goTo("register");
    }
}
