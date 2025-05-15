package org.todolist;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;

public class todo {
    @FXML
    private Button addBtn;

    @FXML
    VBox taskList = new VBox();

    @FXML
    private TextField taskField;

    @FXML
    private ScrollPane scrollPane;


    @FXML
    private void init(){
        addBtn.setOnAction(event -> {
            addTask();
        });
    }

    @FXML
    private void addTask(){
        String taskName = taskField.getText();
        if(taskName.isEmpty()){
            return;
        }
        createNewComponent(taskName);
    }




    private void createNewComponent(String task){
        CheckBox checkBox = new CheckBox();
        Label taskLabel= new Label(task);
        taskLabel.setTextFill(Color.WHITE);
        taskLabel.setFont(Font.font("Poppins", FontWeight.BOLD,18));
        Button editBtn = new Button();
        Button deleteBtn = new Button();
        //creating icon for the edit button and save button
        File editIconfile = new File("src/main/resources/images/edit_icon.png");
        File saveIconFile = new File("src/main/resources/images/save_icon.png");
        File deleteIconFile = new File("src/main/resources/images/delete_icon.png");
        ImageView editIcon = new ImageView(editIconfile.toURI().toString());
        ImageView deleteIcon = new ImageView(deleteIconFile.toURI().toString());
        ImageView saveIcon = new ImageView(saveIconFile.toURI().toString());

        editBtn.setGraphic(editIcon);//setting the edit buttonicon.
        deleteBtn.setGraphic(deleteIcon);



        //HBOX to hold everything in the row.
        HBox newTask = new HBox(10,checkBox,taskLabel,editBtn,deleteBtn);
        newTask.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(taskLabel, Priority.ALWAYS);
        taskLabel.setMaxWidth(Double.MAX_VALUE);
        newTask.setStyle(
                "-fx-background-color: #3b3f58;" +  // dark bluish card
                        "-fx-border-color: black;" +     // rounded corners
                        "-fx-padding: 10;" +               // space inside the box
                        "-fx-spacing: 10;"
        );
        taskLabel.setAlignment(Pos.CENTER_LEFT); // For vertical alignment if needed

        //logic for the edit button
        editBtn.setOnAction(event -> {
            TextField editField = new TextField(taskLabel.getText());
            Button saveBtn = new Button();
            saveBtn.setGraphic(saveIcon); //setting the save Icon
            newTask.getChildren().setAll(checkBox,editField,saveBtn,deleteBtn);

            HBox.setHgrow(editField, Priority.ALWAYS);
            editField.setMaxWidth(Double.MAX_VALUE);

            saveBtn.setOnAction(saveLabel ->{
                taskLabel.setText(editField.getText());
                newTask.getChildren().setAll(checkBox,taskLabel,editBtn,deleteBtn);
            });
        });

        //logic for the delete Button
        deleteBtn.setOnAction(event ->{
            taskList.getChildren().remove(newTask);
        });
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()){
                taskLabel.setStyle("-fx-text-fill: gray");
            } else {
                taskLabel.setStyle("-fx-text-fill: white");
            }
        });

        taskList.getChildren().add(newTask);

        taskField.clear();
    }







}
