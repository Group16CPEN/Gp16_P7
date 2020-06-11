package GameApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.FileInputStream;


import static javafx.scene.text.Font.font;

public class Level1 extends Application {
    private String word;
    static TextField field =new TextField();
    static TextField field1 =new TextField();
    static TextField field2 =new TextField();
    static Button btn;
    static Button btn1;
    static Button btn2;
    Button submit=new Button("SUBMIT");
    public static Label score;
    public static Label hint;
    static DropShadow drop;
    public static Stage stage;
    public static int Level;
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = new Stage();
        stage.setTitle("WORD IDENTIFIER");
        stage.setWidth(480);
        stage.setHeight(710);
        Pane root = new Pane();
        Level = 1;
        StackPane pane = new StackPane();
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

        FileInputStream ic = new FileInputStream("Images/44.png");
        Image ico = new Image(ic);
        ImageView iv = new ImageView(ico);

        FileInputStream io = new FileInputStream("Images/50.png");
        Image ioc = new Image(io);
        ImageView ci = new ImageView(ioc);

        FileInputStream i = new FileInputStream("Images/51.png");
        Image o = new Image(i);
        ImageView c = new ImageView(o);

        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        stage.getIcons().add(icon);


//COMPONENTS
//COMPONENTS WITH THEIR DESIGNS AND DRAG AND DROP IMPLEMENTATION
         Rectangle rectangle = new Rectangle(462,40);
         rectangle.setArcHeight(20);
         rectangle.setArcWidth(20);
         rectangle.setLayoutX(0);
         rectangle.setLayoutY(0);
         rectangle.setFill(Color.DIMGRAY);
        drop = new DropShadow();
        drop.setBlurType(BlurType.GAUSSIAN);
        drop.setColor(Color.BLACK);
        drop.setHeight(100);
        drop.setWidth(150);
        drop.setOffsetX(10);
        drop.setOffsetY(10);
        drop.setSpread(0.2);
        drop.setRadius(10);
        pane.setEffect(drop);


        Rectangle topdash = new Rectangle(430,160);
        topdash.setArcHeight(20);
        topdash.setArcWidth(20);
        topdash.setLayoutX(18);
        topdash.setLayoutY(60);
        topdash.setFill(Color.TRANSPARENT);
        topdash.setStyle("-fx-stroke:green");

        Label label = new Label("BEGINNER");
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size:20px; -fx-text-fill:White;" +
                " -fx-font-weight:bold;-fx-font-style:oblique;" +
                "-fx-font-family:cursive;-fx-font-weight:bold");
        label.setLayoutX(180);
        label.setLayoutY(5);


        Label points = new Label("POINTS");
        points.setTextFill(Color.GREEN);
        points.setStyle("-fx-font-size:20px;-fx-font-weight:bold");
        points.setLayoutY(60);
        points.setLayoutX(190);

        score = new Label("0");
        score.setTextFill(Color.RED);
        score.setStyle("-fx-font-size:30px;-fx-font-weight:bold");
        score.setLayoutY(110);
        score.setLayoutX(220);

        Label hinticon=new Label("",ci);
        hinticon.setLayoutX(10);
        hinticon.setLayoutY(170);

        hint = new Label();
        hint.setLayoutX(18);
        hint.setLayoutY(240);
        hint.setFont(font(15));
        hint.setStyle("-fx-text-alignment:center;-fx-text-fill:blue;" +
                "-fx-font-weight:bold;-fx-spin-enabled:true ;");

        Button HINT=new Button("HINT");
        HINT.setPrefSize(150,50);
        HINT.setLayoutX(50);
        HINT.setLayoutY(170);
        HINT.setStyle("-fx-background-color:linear-gradient(white 0%,#FFFF00 100%,white 20%);" +
                "-fx-text-fill:black;-fx-font-style:oblique;" +
                "-fx-cursor:hand;");
        HINT.setOnAction(actionEvent -> {
            if(hint.getText().equals("")) {
                hint.setText(Level1Alg.getHint().toUpperCase());
            }else {
                hint.setText("");
            }
        });

        Label gameicon=new Label("",c);
        gameicon.setLayoutX(201);
        gameicon.setLayoutY(170);


        Button Dash=new Button("DASHBOARD");
        Dash.setPrefSize(150,50);
        Dash.setLayoutX(249);
        Dash.setLayoutY(170);
        Dash.setStyle("-fx-background-color:linear-gradient(white 0%,#FFFF00 100%,white 20%);" +
                "-fx-text-fill:black;-fx-font-style:oblique;" +
                "-fx-cursor:hand;");
        Dash.setOnAction(actionEvent -> {
            stage.close();
            Dashboard db = new Dashboard();
            try {
                db.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Label dashicon =new Label("",iv);
        dashicon.setLayoutX(400);
        dashicon.setLayoutY(170);



        field =new TextField();
        field.setPrefSize(73,63);
        field.setLayoutX(110);
        field.setLayoutY(330);
        field.setStyle("-fx-alignment:center;-fx-min-width:73px;-fx-min-height:63px;" +
                "-fx-border-radius:10px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-cursor:null;-fx-font-size:20px;");
        field.setOnMouseDragReleased(event -> {
            Button value=(Button) event.getGestureSource();
            field.setText(value.getText());
        });

        btn = new Button();
        btn.setPrefSize(73,63);
        btn.setLayoutX(110);
        btn.setLayoutY(490);
        btn.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand;");
        btn.setOnDragDetected(event -> btn.startFullDrag());


        field1 =new TextField();
        field1.setPrefSize(73,63);
        field1.setLayoutX(195);
        field1.setLayoutY(330);
        field1.setStyle("-fx-alignment:center;-fx-min-width:73px;-fx-min-height:63px;" +
                "-fx-border-radius:10px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-cursor:null;-fx-font-size:20px;");
        field1.setOnMouseDragReleased(event -> {
            Button value=(Button) event.getGestureSource();
            field1.setText(value.getText());
        });

        btn1 = new Button();
        btn1.setPrefSize(73,63);
        btn1.setLayoutX(195);
        btn1.setLayoutY(490);
        btn1.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand ;");
        btn1.setOnDragDetected(event -> btn1.startFullDrag());

        field2 =new TextField();
        field2.setPrefSize(73,63);
        field2.setLayoutX(280);
        field2.setLayoutY(330);
        field2.setStyle("-fx-alignment:center;-fx-min-width:73px;-fx-min-height:63px;" +
                "-fx-border-radius:10px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-cursor:null;-fx-font-size:20px;");
        field2.setOnMouseDragReleased(event -> {
            Button value=(Button) event.getGestureSource();
            field2.setText(value.getText());
        });

        btn2 = new Button();
        btn2.setPrefSize(73,63);
        btn2.setLayoutX(280);
        btn2.setLayoutY(490);
        btn2.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand;");
        btn2.setOnDragDetected(event -> btn2.startFullDrag());
//END OF COMPONENTS WITH THEIR DESIGNS AND DRAG AND DROP IMPLEMENTATION
        submit.setPrefSize(150,50);
        submit.setLayoutX(165);
        submit.setLayoutY(580);
        submit.setStyle("-fx-text-fill:white;-fx-border-insets:30px;-fx-background-color:yellow;-fx-cursor:hand;");
        submit.setOnAction(arg0 -> {
            word = getIndividualLetters();
            String answer = Level1Alg.getCurrentWord();
            if (word.isEmpty()) {
                ClearSlots();
                Level1Alg.wordindexcheck();
                hint.setText("");
            } else if (Compare(word, answer)) {
                ClearSlots();
                Level1Alg.wordindexcheck();
                Points.Point();
                hint.setText("");
            } else if (!Compare(word, answer)) {
                ClearSlots();
                Level1Alg.wordindexcheck();
                hint.setText("");
            }
        });
//END OF COMPONENTS
        stage.setOnCloseRequest(windowEvent -> {
            Dashboard dashboard = new Dashboard();
            try {
                dashboard.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
         pane.setStyle("-fx-background-color:gray;-fx-min-height:1cm;" +
                 "-fx-font-size:20px;-fx-font-style:oblique;" +
                 "-fx-font-family:cursive;-fx-font-weight:bold;" +
                 "-fx-border-color:lightblue;-fx-border-radius:10px;");
         pane.getChildren().add(rectangle);
        root.getChildren().addAll(pane,label,topdash,points,score,hinticon,HINT,gameicon,Dash,dashicon,field,field1,field2,btn,btn1,btn2,submit,hint);
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

        //GAME START METHOD
        Level1Alg.levelstart();
//END OF GAME START METHOD
    }

    //INDIVIDUAL LETTER SCRAMBLING
    public static void LetterScrambling(String word) {
        char[] letters= ScramblingAlg.scramble(word);
        String one=""+letters[0];
        btn.setText(one);
        String two=""+letters[1];
        btn1.setText(two);
        String three=""+letters[2];
        btn2.setText(three);
    }
//END OF INDIVIDUAL LETTER SCRAMBLING

    private boolean Compare(String word, String answer) {
        boolean state = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.codePointAt(i) != answer.codePointAt(i)) {
                state = false;
                break;
            }
        }
        return state;
    }
    //GETTING INDIVIDUAL LETTERS TO FORM A WORD STRING
    public static String getIndividualLetters() {
        return field.getText()+ field1.getText()+ field2.getText();
    }
    //END OF WORD STRING

    //RESETTING SLOTS TO EMPTY
    public static void ClearSlots() {
        field.setText("");
        field1.setText("");
        field2.setText("");
    }
    //END OF RESETTING SLOTS TO EMPTY

    public static void main(String[] args) {
        launch(args);
    }
}
