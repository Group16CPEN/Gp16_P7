package GameApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
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

public class Register extends Application {

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Word Identifier");
        primaryStage.setWidth(550);
        primaryStage.setHeight(600);
        Pane root = new Pane();

        //BACKGROUND IMAGE
        FileInputStream input = new FileInputStream("Images/reg.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Background background= new Background(backgroundImage);
        root.setBackground(background);

        //BUTTON IMAGES
        FileInputStream ic= new FileInputStream("Images/30.png");
        Image ico = new Image(ic);
        ImageView iv = new ImageView(ico);

        FileInputStream i= new FileInputStream("Images/30.png");
        Image io = new Image(i);
        ImageView v = new ImageView(io);



        //WINDOW ICON
        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        primaryStage.getIcons().add(icon);

        //COMPONENT INITIALISATION AND DESIGN
        Label label = new Label("SIGNUP",v);
        label.setFont(new Font("Segoe Script",36));
        label.setPrefSize(250,70);
        label.setLayoutX(150);
        label.setLayoutY(30);
        label.setStyle(" -fx-text-fill:White; -fx-font-weight:bold italic;");


        Label first = new Label("FIRSTNAME:");
        first.setFont(new Font("Segoe Script",14));
        first.setPrefSize(96,24);
        first.setLayoutX(30);
        first.setLayoutY(150);
        first.setStyle(" -fx-text-fill:white; -fx-font-weight:bold");


        Label last = new Label("LASTNAME:");
        last.setFont(new Font("Segoe Script",14));
        last.setPrefSize(95,24);
        last.setLayoutX(30);
        last.setLayoutY(220);
        last.setStyle("-fx-text-fill:white; -fx-font-weight:bold");

        Label User = new Label("USERNAME:");
        User.setFont(new Font("Segoe Script",14));
        User.setPrefSize(95,24);
        User.setLayoutX(30);
        User.setLayoutY(290);
        User.setStyle(" -fx-text-fill:white; -fx-font-weight:bold");

        Label Pass = new Label("PASSWORD:");
        Pass.setFont(new Font("Segoe Script",14));
        Pass.setPrefSize(95,24);
        Pass.setLayoutX(30);
        Pass.setLayoutY(360);
        Pass.setStyle(" -fx-text-fill:white; -fx-font-weight:bold");

        TextField fn = new TextField();
        fn.setFont(font(14));
        fn.setPrefSize(240,50);
        fn.setPromptText("FIRSTNAME");
        fn.setLayoutX(150);
        fn.setLayoutY(140);

        TextField ln = new TextField();
        ln.setFont(font(14));
        ln.setPrefSize(240,50);
        ln.setPromptText("LASTNAME");
        ln.setLayoutX(150);
        ln.setLayoutY(210);

        TextField field = new TextField();
        field.setFont(font(14));
        field.setPrefSize(240,50);
        field.setPromptText("USERNAME");
        field.setLayoutX(150);
        field.setLayoutY(280);

        PasswordField pass = new PasswordField();
        pass.setFont(font(14));
        pass.setPrefSize(240,50);
        pass.setPromptText("PASSWORD");
        pass.setLayoutX(150);
        pass.setLayoutY(350);


        //LOGIN PAGE LINK
        Label sign = new Label("ALREADY GAMING? LOGIN!");
        sign.setPrefSize(180,24);
        sign.setLayoutX(180);
        sign.setLayoutY(536);
        sign.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        sign.setOnMouseEntered(mouseEvent -> {
            sign.setCursor(Cursor.HAND);
            sign.setBorder(new Border(new BorderStroke(Color.BLUE,BorderStrokeStyle.DASHED,null,new BorderWidths(1))));
        });
        sign.setOnMouseExited(mouseEvent -> sign.setBorder(null));
        sign.setOnMouseClicked(mouseEvent -> {
            Login lf = new Login();
            try {
                lf.start(primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });


        Button Btn = new Button("SIGNUP",iv);
        Btn.setFont(new Font("Segoe Script",24));
        Btn.setPrefSize(240,80);
        Btn.setLayoutX(145);
        Btn.setLayoutY(450);
        Btn.setStyle("-fx-background-color:burlywood; -fx-text-fill:White; -fx-font-weight:bold;");
        Btn.setOnMouseEntered(mouseEvent -> Btn.setCursor(Cursor.HAND));
        Btn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String fname = fn.getText();
                String lname = ln.getText();
                String username = field.getText();
                String pass1 = String.valueOf(pass.getText());

                if (verifyFields()) {
                    try {
                        if (!checkUsername(username)) {
                            PreparedStatement ps;
                            ResultSet rs;
                            String registerUserQuery = "INSERT INTO `user_details`(`Firstname`, `Lastname`, `Username`, `Password`) VALUES (?,?,?,?)";

                            try {
                                ps = DBCon.getConnection().prepareStatement(registerUserQuery);
                                ps.setString(1, fname);
                                ps.setString(2, lname);
                                ps.setString(3, username);
                                ps.setString(4, pass1);

                                if (ps.executeUpdate() != 0) {
                                    Alert al = new Alert(Alert.AlertType.INFORMATION, "GAMER!!");
                                    al.show();
                                } else {
                                    Alert ale = new Alert(Alert.AlertType.ERROR, "REVIEW DETAILS");
                                    ale.show();
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean verifyFields() {
                String fname = fn.getText();
                String lname = ln.getText();
                String uname = field.getText();
                String pass1 = String.valueOf(pass.getText());

                if (fname.trim().equals("") || lname.trim().equals("") || uname.trim().equals("") || pass1.trim().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "One or More Empty Fields");
                    alert.show();

                    return false;
                } else
                    return true;
            }

            private boolean checkUsername(String username) throws Exception {
                PreparedStatement st;
                ResultSet rs;
                boolean username_exist = false;

                String query = "SELECT * FROM `user_details` WHERE `Username` = ?";

                try {

                    st = DBCon.getConnection().prepareStatement(query);
                    st.setString(1, username);
                    rs = st.executeQuery();

                    if (rs.next()) {
                        username_exist = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR, "This Username is Already Taken, Choose Another One");
                        alert.show();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return username_exist;
            }
        });
        root.getChildren().addAll( fn,ln,field,pass,Btn,label,User,Pass,first,last,sign);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

