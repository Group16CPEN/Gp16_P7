package GameApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.scene.text.Font.font;

public class Login extends Application {
    public static String username;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        primaryStage.setTitle("WORD IDENTIFIER");
        primaryStage.setWidth(520);
        primaryStage.setHeight(600);
        Pane root = new Pane();

        //BACKGROUND IMAGE
        FileInputStream input= new FileInputStream("Images/log.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Background background= new Background(backgroundImage);
        root.setBackground(background);

        //BUTTON AND FIELD IMAGES
        FileInputStream i= new FileInputStream("Images/logg.png");
        Image io = new Image(i);
        ImageView v = new ImageView(io);

        FileInputStream ic= new FileInputStream("Images/logg.png");
        Image ico = new Image(ic);
        ImageView iv = new ImageView(ico);

        FileInputStream ii= new FileInputStream("Images/26.png");
        Image iii = new Image(ii);
        ImageView vi = new ImageView(iii);

        FileInputStream vii= new FileInputStream("Images/23.png");
        Image ik = new Image(vii);
        ImageView l = new ImageView(ik);

        //WINDOW ICON
        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        primaryStage.getIcons().add(icon);

        //COMPONENTS AND THEIR SPECIFICATIONS
        Label label = new Label("LOGIN",v);
        label.setFont(new Font("Segoe Script",36));
        label.setPrefHeight(70);
        label.setPrefWidth(190);
        label.setLayoutX(150);
        label.setLayoutY(30);
        label.setStyle(" -fx-text-fill:White; -fx-font-weight:bold;");

        Label User = new Label("USERNAME");
        User.setFont(new Font("Segoe Script",14));
        User.setPrefHeight(24);
        User.setPrefWidth(92);
        User.setLayoutX(145);
        User.setLayoutY(155);
        User.setStyle(" -fx-text-fill:white; -fx-font-weight:bold");

        Label Pass = new Label("PASSWORD");
        Pass.setFont(new Font("Segoe Script",14));
        Pass.setPrefHeight(24);
        Pass.setPrefWidth(92);
        Pass.setLayoutX(145);
        Pass.setLayoutY(275);
        Pass.setStyle("-fx-text-fill:white; -fx-font-weight:bold");

        TextField field = new TextField();
        field.setFont(font(14));
        field.setPrefWidth(240);
        field.setPrefHeight(50);
        field.setPromptText("USERNAME");
        field.setLayoutX(145);
        field.setLayoutY(180);

        PasswordField pass = new PasswordField();
        pass.setFont(font(14));
        pass.setPrefWidth(240);
        pass.setPrefHeight(50);
        pass.setPromptText("PASSWORD");
        pass.setLayoutX(145);
        pass.setLayoutY(300);

        //FIELD IMAGES
        Label user = new Label("",vi);
        user.setLayoutX(90);
        user.setLayoutY(180);

        Label pAss = new Label("",l);
        pAss.setLayoutX(100);
        pAss.setLayoutY(310);

       //REGISTER PAGE LINK
        Label sign = new Label("NEW GAMER? SIGNUP!");
        sign.setPrefHeight(24);
        sign.setPrefWidth(150);
        sign.setLayoutX(200);
        sign.setLayoutY(520);
        sign.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        sign.setOnMouseEntered(mouseEvent -> {
            sign.setCursor(Cursor.HAND);
            sign.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.DASHED,null,new BorderWidths(1))));
        });

        sign.setOnMouseExited(mouseEvent -> sign.setBorder(null));

        sign.setOnMouseClicked(mouseEvent -> {
            Register rf = new Register();
            try {
                rf.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

      //LOGIN BUTTON
        Button Btn = new Button("LOGIN",iv);
        Btn.setFont(new Font("Segoe Script",30));
        Btn.setPrefHeight(80);
        Btn.setPrefWidth(240);
        Btn.setLayoutX(145);
        Btn.setLayoutY(420);
        Btn.setStyle("-fx-background-color:burlywood; -fx-text-fill:White; -fx-font-weight:bold;");


        Btn.setOnMouseEntered(mouseEvent -> Btn.setCursor(Cursor.HAND));



        Btn.setOnMouseClicked(mouseEvent -> {
            PreparedStatement ps;
            ResultSet rs;

            username = field.getText();
            String password = pass.getText();

            String query = "SELECT * FROM `user_details` WHERE `Username` = ? AND `Password` = ?";

            if (field.getText().isEmpty() || pass.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "One or More Empty Fields");
                alert.show();
            }else{
                try{
                    ps = DBCon.getConnection().prepareStatement(query);

                    ps.setString(1, username);
                    ps.setString(2, password);
                    rs = ps.executeQuery();


                    if(rs.next()){
                        Home D = new Home();
                        try {
                            D.start(primaryStage);
                            D.label.setText("WELCOME " + username.toUpperCase());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Username / Password");
                        alert.show();
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        root.getChildren().addAll(field,pass,Btn,label,User,Pass,sign,user,pAss);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}