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

public class Level3 extends Application {
    private String word;
    static TextField field =new TextField();
    static TextField field1 =new TextField();
    static TextField field2 =new TextField();
    static TextField field3=new TextField();
    static TextField field4 =new TextField();
    static Button btn;
    static Button btn1;
    static Button btn2;
    static Button btn3;
    static Button btn4;
    static DropShadow drop;
    public static Stage stage;
    public static int Level;
    Scene scene;
    Button submit=new Button("SUBMIT");
    public static Label score;
    public static Label hint;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = new Stage();
        stage.setTitle("WORD IDENTIFIER");
        stage.setWidth(480);
        stage.setHeight(710);
        Pane root = new Pane();
        Level = 3;
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

        Label label = new Label("MASTER");
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size:20px; -fx-text-fill:White;" +
                "-fx-font-weight:bold;-fx-font-style:oblique;" +
                "-fx-font-family:cursive;-fx-font-weight:bold");
        label.setLayoutX(200);
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
                "-fx-text-fill:black;-fx-font-style:oblique;-fx-cursor:hand;");
        HINT.setOnAction(actionEvent -> {
            if(hint.getText().equals("")) {
                hint.setText(Level3Alg.getHint().toUpperCase());
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
                "-fx-text-fill:black;-fx-font-style:oblique;-fx-cursor:hand;");
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
        field.setLayoutX(34);
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
        btn.setLayoutX(34);
        btn.setLayoutY(490);
        btn.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand ;");
        btn.setOnDragDetected(event -> btn.startFullDrag());


        field1 =new TextField();
        field1.setPrefSize(73,63);
        field1.setLayoutX(115);
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
        btn1.setLayoutX(115);
        btn1.setLayoutY(490);
        btn1.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand ;");
        btn1.setOnDragDetected(event -> btn1.startFullDrag());

        field2 =new TextField();
        field2.setPrefSize(73,63);
        field2.setLayoutX(196);
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
        btn2.setLayoutX(196);
        btn2.setLayoutY(490);
        btn2.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand ;");
        btn2.setOnDragDetected(event -> btn2.startFullDrag());

        field3 =new TextField();
        field3.setPrefSize(73,63);
        field3.setLayoutX(278);
        field3.setLayoutY(330);
        field3.setStyle("-fx-alignment:center;-fx-min-width:73px;-fx-min-height:63px;" +
                "-fx-border-radius:10px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-cursor:null;-fx-font-size:20px;");
        field3.setOnMouseDragReleased(event -> {
            Button value=(Button) event.getGestureSource();
            field3.setText(value.getText());
        });

        btn3 = new Button();
        btn3.setPrefSize(73,63);
        btn3.setLayoutX(278);
        btn3.setLayoutY(490);
        btn3.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand ;");
        btn3.setOnDragDetected(event -> btn3.startFullDrag());

        field4 =new TextField();
        field4.setPrefSize(73,63);
        field4.setLayoutX(359);
        field4.setLayoutY(330);
        field4.setStyle("-fx-alignment:center;-fx-min-width:73px;-fx-min-height:63px;" +
                "-fx-border-radius:10px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-cursor:null;-fx-font-size:20px;");
        field4.setOnMouseDragReleased(event -> {
            Button value=(Button) event.getGestureSource();
            field4.setText(value.getText());
        });

        btn4 = new Button();
        btn4.setPrefSize(73,63);
        btn4.setLayoutX(359);
        btn4.setLayoutY(490);
        btn4.setStyle("-fx-font-size:20px;-fx-background-color:linear-gradient(white 20%,#DEB887 100%,white 70%);" +
                "-fx-border-radius:10px;-fx-cursor:hand;");
        btn4.setOnDragDetected(event -> btn4.startFullDrag());
//END OF COMPONENTS WITH THEIR DESIGNS AND DRAG AND DROP IMPLEMENTATION

        submit.setPrefSize(150,50);
        submit.setLayoutX(165);
        submit.setLayoutY(580);
        submit.setStyle("-fx-text-fill:white;-fx-border-insets:30px;-fx-background-color:yellow;-fx-cursor:hand;");
        submit.setOnAction(arg0 -> {
            word = getIndividualLetters();
            String answer= Level3Alg.getCurrentWord();
            if(word.isEmpty()) {
                ClearSlots();
                Level3Alg.wordindexcheck();
                hint.setText("");
            } else if(Compare(word,answer)) {
                ClearSlots();
                Level3Alg.wordindexcheck();
                Points.Points3();
                hint.setText("");
            }else if (!Compare(word,answer)){
                ClearSlots();
                Level3Alg.wordindexcheck();
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
        root.getChildren().addAll(pane,label,topdash,points,score,hinticon,HINT,gameicon,Dash,dashicon,field,field1,field2,field3,field4,btn,btn1,btn2,btn3,btn4,submit,hint);
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

        //GAME START METHOD
        Level3Alg.levelstart();
        //END OF GAME START
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
        String four=""+letters[3];
        btn3.setText(four);
        String five=""+letters[4];
        btn4.setText(five);
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
        return field.getText()+ field1.getText()+ field2.getText()+ field3.getText()+field4.getText();
    }
    //END OF WORD STRING

    //RESETTING SLOTS TO EMPTY
    public static void ClearSlots() {
        field.setText("");
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
    }
    //END OF RESETTING SLOTS TO EMPTY
    public static void main(String[] args) {
        launch(args);
    }
}
