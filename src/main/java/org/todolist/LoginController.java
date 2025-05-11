package org.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    //controller for the login page

    @FXML
    private Button submitBtn;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label invalidcredLabel;
    @FXML
    private Button signupPageBtn;

    @FXML
    private void userLogIn(ActionEvent event){
        System.out.println("logged in.");
    }



}
