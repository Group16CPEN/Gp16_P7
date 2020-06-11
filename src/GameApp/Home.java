package GameApp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;

import static javafx.scene.text.Font.font;

public class Home extends Application {

    public Label label;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("WORD IDENTIFIER");
        primaryStage.setWidth(550);
        primaryStage.setHeight(600);
        Pane root = new Pane();
        FileInputStream input= new FileInputStream("Images/17.jpg");
        Image image = new Image(input);

        FileInputStream ic= new FileInputStream("Images/41.png");
        Image ico = new Image(ic);
        ImageView iv = new ImageView(ico);

        FileInputStream i= new FileInputStream("Images/40.png");
        Image io = new Image(i);
        ImageView it = new ImageView(io);


        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background= new Background(backgroundImage);
        root.setBackground(background);

        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        primaryStage.getIcons().add(icon);


        label = new Label();
        label.setFont(font(30));
        label.setPrefSize(500,70);
        label.setLayoutX(0);
        label.setLayoutY(30);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-font-family:cursive;-fx-font-style:oblique ;" +
                " -fx-text-fill:linear-gradient(white 0%,#696969 100%,white 20%); -fx-font-weight:bold");



        Button btn = new Button("PLAY",iv);
        btn.setFont(new Font("Segoe Script",30));
        btn.setPrefSize(240,80);
        btn.setLayoutX(145);
        btn.setLayoutY(180);
        btn.setStyle("-fx-background-color:blue;-fx-text-fill:white");



        Button btn2 = new Button("LOGOUT",it);
        btn2.setFont(new Font("Segoe Script",30));
        btn2.setPrefSize(270,80);
        btn2.setLayoutX(130);
        btn2.setLayoutY(360);
        btn2.setStyle("-fx-background-color:red;-fx-text-fill:white");


        root.getChildren().addAll(label,btn,btn2);

        btn.setOnMouseEntered(mouseEvent -> btn.setCursor(Cursor.HAND));

        btn2.setOnMouseEntered(mouseEvent -> btn2.setCursor(Cursor.HAND));


        btn.setOnAction(actionEvent -> {
            Dashboard mi = new Dashboard();
            try {
                mi.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.close();
        });


        btn2.setOnAction(actionEvent -> {
            int confirmed = JOptionPane.showConfirmDialog(null,"ARE YOU SURE YOU WANT TO LOGOUT?","LOGOUT",JOptionPane.YES_NO_OPTION) ;
            if(confirmed== JOptionPane.YES_OPTION)
            {
                Login lf = new Login();
                try {
                    lf.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"SEE YOU REAL SOON!");
                alert.show();
            }else {
                try {
                    stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
