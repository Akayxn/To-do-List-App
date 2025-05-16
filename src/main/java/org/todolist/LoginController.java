package org.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;


import java.io.IOException;
import java.sql.*;

import static org.todolist.SignUpController.checkConnection;

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
    private Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32,64,1,15*1024,2);

    static String dbFilePath = "userinfo.db";
    static String tableName = "users";

    Main main = new Main();

    @FXML
    public void initialize(){
        signupPageBtn.setOnAction(event -> {

            try {
                main.changeScene("signup.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        submitBtn.setOnAction(event -> {
            try {
                if(userLogIn()){
                    main.changeScene("todo.fxml");
                }
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });


    }

    @FXML
    private boolean userLogIn() throws SQLException, IOException {
        String username = usernameField.getText().toLowerCase();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            invalidcredLabel.setText("All fields are required!");
            invalidcredLabel.setTextFill(Color.RED);
            return false;
        }

        if(!SignUpController.getUsernameList().contains(username)) {
            invalidcredLabel.setText("No Records with that username.");
            invalidcredLabel.setTextFill(Color.RED);
            return false;
        }
        if(checkAccount(username,password)){
            invalidcredLabel.setText("Sucessfully Logged in.");
            invalidcredLabel.setTextFill(Color.GREEN);
            return true;
        }
        else{
            invalidcredLabel.setText("Invalid Credentials!");
            invalidcredLabel.setTextFill(Color.RED);
            return false;
        }
    }

    public boolean checkAccount(String username, String password) throws SQLException {
        Connection connection = checkConnection();
        Statement statement = connection.createStatement();
        if (connection != null) {
            try {
                String sql = "SELECT * FROM " + tableName + " WHERE username=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                ResultSet resultSet= preparedStatement.executeQuery();

                if(resultSet.next()){
                    String hashedPassword = resultSet.getString("password");
                    resultSet.close();
                    preparedStatement.close();
                    return encoder.matches(password,hashedPassword);
                }
                else{
                    resultSet.close();
                    preparedStatement.close();
                    return false;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }





}
