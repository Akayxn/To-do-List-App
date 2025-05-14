module org.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires jdk.dynalink;


    opens org.todolist to javafx.fxml;
    exports org.todolist;
}