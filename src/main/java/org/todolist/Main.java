package org.todolist;

import javafx.application.Application;
import javafx.css.converter.SizeConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene loginPage,registrationPage;
    Button loginBtn,signupBtn,loginSwitch,signupSwitch;
    Label signUpLabel,loginLabel;


    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("To Do List App");
        window.setWidth(800);
        window.setHeight(500);
        window.setResizable(false);

        Group root = new Group();
        loginPage = new Scene(root,Color.GREEN);
        loginLabel = new Label("Login");
        loginLabel.setLayoutX(400);
        loginLabel.setLayoutY(20);
        loginLabel.setFont(Font.font("Poppins", FontWeight.BOLD,20));

        root.getChildren().add(loginLabel);







//        signUpLabel = new Label("Signup Form");
//        loginLabel = new Label("Login Form");
//
//
//        loginSwitch = new Button();
//        loginSwitch.setText("Login");
//        signupSwitch = new Button();
//        signupSwitch.setText("Signup");
//        Group switchGroup = new Group();
//        switchGroup.getChildren().addAll(loginSwitch,signupSwitch);
//
//        VBox vboxLayout = new VBox(15);// setting the vbox layout.
//        HBox hBoxLayout = new HBox(10); // setting the hbox layout.
//        hBoxLayout.getChildren().addAll(loginSwitch,signupSwitch);
//        hBoxLayout.setAlignment(Pos.TOP_CENTER);
//
//        vboxLayout.getChildren().addAll(loginLabel,hBoxLayout);
//        vboxLayout.setAlignment(Pos.TOP_CENTER);
//
//        loginPage = new Scene(vboxLayout,800,500);







        window.setScene(loginPage);
        window.show(); // makes it visible
    }


    public static void main(String[] args) {
        launch(args);

    }
}
