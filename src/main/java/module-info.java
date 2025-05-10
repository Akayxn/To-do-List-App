module org.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.todolist to javafx.fxml;
    exports org.todolist;
}