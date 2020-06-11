package GameApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;

public class Dashboard extends Application {
    Scene scene0;
    public Label label;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = new Stage();
        stage.setWidth(500);
        stage.setHeight(600);
        Pane root = new Pane();
        stage.setTitle("WORD IDENTIFIER");
        FileInputStream input = new FileInputStream("Images/17.jpg");
        Image image = new Image(input);


        BackgroundImage backGroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background backGround = new Background(backGroundImage);
        root.setBackground(backGround);
        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        stage.getIcons().add(icon);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        dropShadow.setColor(Color.web("#000000"));

        label = new Label("LEVEL SELECT");
        label.setFont(new Font("Segoe Script", 36));
        label.setPrefSize(500, 70);
        label.setLayoutX(100);
        label.setLayoutY(30);
        label.setStyle(" -fx-text-fill:linear-gradient(white 0%,#FFFF00 100%,white 20%); -fx-font-weight:bold");


        Button L1 = new Button("1");
        L1.setPrefSize(100, 100);
        L1.setStyle("-fx-background-color: #804000;" +
                "-fx-text-fill: #ffffff; -fx-padding: 10;" +
                "-fx-font-size: 20px; -fx-font-weight: bold;");
        L1.setEffect(dropShadow);
        L1.setCursor(Cursor.HAND);


        Button L2 = new Button("2");
        L2.setPrefSize(100, 100);
        L2.setStyle("-fx-background-color: #804000;" +
                "-fx-text-fill: #ffffff; -fx-padding: 10;" +
                "-fx-font-size: 20px; -fx-font-weight: bold;");
        L2.setEffect(dropShadow);
        L2.setCursor(Cursor.HAND);

        Button L3 = new Button("3");
        L3.setPrefSize(100, 100);
        L3.setStyle("-fx-background-color: #804000;" +
                "-fx-text-fill: #ffffff; -fx-padding: 10;" +
                "-fx-font-size: 20px; -fx-font-weight: bold;");
        L3.setEffect(dropShadow);
        L3.setCursor(Cursor.HAND);


        TilePane tilePane = new TilePane(L1, L2, L3);
        tilePane.setAlignment(Pos.CENTER_LEFT);
        tilePane.setHgap(20);
        tilePane.setVgap(20);
        tilePane.setLayoutX(75);
        tilePane.setLayoutY(250);


        L1.setOnAction(actionEvent -> {
            Level1 bd = new Level1();
            try {
                bd.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.close();
            primaryStage.close();
            stage.close();
        });

        L2.setOnAction(actionEvent -> {
            Level2 bd2 = new Level2();
            try {
                bd2.start(primaryStage);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.close();
            primaryStage.close();
            stage.close();
        });

        L3.setOnAction(actionEvent -> {
            Level3 bd3 = new Level3();
            try {
                bd3.start(primaryStage);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.close();
            primaryStage.close();
            stage.close();
        });

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
               stage.close();
                Home home = new Home();

                try {
                    home.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        root.getChildren().addAll(label, tilePane);
        scene0 = new Scene(root);
        stage.setScene(scene0);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
