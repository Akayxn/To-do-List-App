module org.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.todolist to javafx.fxml;
    exports org.todolist;
}