package org.todolist;
import javafx.scene.paint.Color;
import lombok.Getter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.todolist.models.ConnectDB;



import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUpController {
    @Getter
    private static final List<String> usernameList;
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
    private  Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32,64,1,15*1024,2);

    private static ConnectDB db = new ConnectDB();

    static String dbFilePath = "userinfo.db";
    static String tableName = "users";
    static {
        try {
            Statement statement = checkConnection().createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS users(username TEXT PRIMARY KEY,password TEXT)";
            statement.execute(createTable);
            usernameList = ListUsername();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize() {
        LoginPageBtn.setOnAction(event -> {
            Main main = new Main();
            try {
                main.changeScene("login.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        submitBtn.setOnAction(event -> {
            try {
                registerUser();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
    }

    @FXML
    private void registerUser() throws SQLException {
        String username = usernameField.getText().toLowerCase(); // storing the textfield values into the username
        CharSequence passwordChar = passwordField.getCharacters(); // making the pass into charseq
        String password = passwordChar.toString();
        CharSequence confirmPasswordChar = confirmPasswordField.getCharacters();
        String confirmPassword = confirmPasswordChar.toString();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            invalidcredLabel.setText("All fields are required!");
            invalidcredLabel.setTextFill(Color.RED);
            return;
        }


        if (usernameList.contains(username)) {
            invalidcredLabel.setText("Username already taken.");
            invalidcredLabel.setTextFill(Color.RED);
            return;
        }

        if (!password.equals(confirmPassword)) {
            invalidcredLabel.setText("Passwords do not match!");
            invalidcredLabel.setTextFill(Color.RED);
            return;
        }

        String labelStatus = insertNewUser(username, password);
        invalidcredLabel.setText(labelStatus);
        invalidcredLabel.setTextFill(Color.GREEN);
    }


    static Connection checkConnection() {
        return db.getConnection();
    }


    public String insertNewUser(String username, String password) throws SQLException {
        var encodedPassword = encoder.encode(password);
        Connection connection = checkConnection();
        Statement statement = connection.createStatement();
        if (connection != null) {
            try {
                String sql = "INSERT INTO " + tableName + " values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, encodedPassword);
                preparedStatement.executeUpdate();
                usernameList.add(username);
                return "Successfully created user: " + username;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private static List<String> ListUsername() {
        String columnName = "username";
        List<String> lines = new ArrayList<>();
        String url = "jdbc:sqlite:" + dbFilePath;

        try {
            Connection connection = checkConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + columnName + " FROM " + tableName);
            while (resultSet.next()) {
                String line = resultSet.getString(columnName);
                lines.add(line);
            }
            return lines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}