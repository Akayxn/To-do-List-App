package org.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    public void initialize(){
        signupPageBtn.setOnAction(event -> {
            Main main = new Main();
            try {
                main.changeScene("signup.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @FXML
    private void userLogIn(ActionEvent event){
        System.out.println("logged in.");
    }

    private void checkLogin(){
        Main main = new Main(); // to use the change scene
        // put the code after implementing the database
    }





}
