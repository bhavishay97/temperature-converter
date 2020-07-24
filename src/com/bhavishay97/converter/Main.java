package com.bhavishay97.converter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;


public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }

    private MenuBar createMenu() {

        // File menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("New menu item clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        // Help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first desktop app");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("Convert temperature with this simple Java app!");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && (clickedBtn.get() == yesBtn)) {
            System.out.println("Yes button clicked!");
        } else {
            System.out.println("No button clicked!");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
