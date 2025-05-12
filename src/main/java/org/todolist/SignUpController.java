package org.todolist;
import org.todolist.models.ConnectDB;


import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button submitBtn;
    @FXML
    private Button LoginPageBtn;
    @FXML
    private Label invalidcredLabel;



    @FXML
    public void initialize(){
        LoginPageBtn.setOnAction(event -> {
            Main main = new Main();
            try {
                main.changeScene("login.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            Statement statement = checkConnection().createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS users(username TEXT PRIMARY KEY,password TEXT)";
            statement.execute(createTable);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }



    @FXML
    private void registerUser(){

    }

    private Connection checkConnection(){
        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        return connection;
    }

    private void checkRegistration(){
        Main main = new Main(); // to use the change scene
        String username=usernameField.getText(); // storing the textfield values into the username
        CharSequence passwordChar =passwordField.getCharacters(); // making the pass into charseq
        String password = passwordChar.toString();


    }


    public void insertNewUser(){
        Connection connection = checkConnection();
        if(connection!=null){




        }
    }


}
