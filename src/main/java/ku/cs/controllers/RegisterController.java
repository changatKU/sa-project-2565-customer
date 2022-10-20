package ku.cs.controllers;

import com.github.saacsos.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ku.cs.services.DBConnector;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    TextField usernameTF, passwordTF, confirmPasswordTF, phoneTF, nameTF, taxTF;

    @FXML
    TextArea addressTA;

    @FXML
    Label registerLB;

    public void handleRegisterButton(){
        String command = "INSERT INTO Customer(Username, Password, Tax_ID, C_Name, C_Phone, Address)"
                + "VALUES(" + "\"" + usernameTF.getText() + "\"" + "," + "\""+ passwordTF.getText() + "\"" + "," + "\"" + taxTF.getText()+ "\"" + ","
                + "\"" + nameTF.getText()+ "\"" + "," + "\"" + phoneTF.getText() + "\"" + "," + "\"" + addressTA.getText()+ "\"" + ")";

        System.out.println(command);
        try {
            DBConnector.insert(command);
            registerLB.setText("Registration Complete");
        } catch (SQLException e) {
            registerLB.setText("Tax ID or Username is exit");
        }
    }

    public void handleLoginButton() throws IOException {
        FXRouter.goTo("login");
    }
}
