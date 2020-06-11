package GameApp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Notification{
    public void CompletedLevel() {
        Stage stage = new Stage();
        stage.setTitle("POPUP");
        stage.setHeight(300);
        stage.setWidth(335);
        Pane root = new Pane();
        Image icon = new Image(getClass().getResourceAsStream("43.png"));
        stage.getIcons().add(icon);


        Label label =new Label("COMPLETED!!!!");
        label.setFont(new Font("Segoe Script",25));
        label.setStyle("-fx-font-weight:bold;-fx-text-fill:yellow");

        Button btn5 = new Button("DONE");
        btn5.setLayoutX(90);
        btn5.setLayoutY(206);
        btn5.setPrefSize(150,50);
        btn5.setStyle("-fx-text-fill:white;-fx-border-insets:30px;-fx-background-color:burlywood;-fx-cursor:hand;");
        btn5.setOnAction(actionEvent -> {
            stage.close();
            if (Level1.Level == 1) {
                Level1.stage.close();
                Dashboard db = new Dashboard();
                try {
                    db.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          else  if (Level2.Level == 2) {
                Level2.stage.close();
                Dashboard db = new Dashboard();
                try {
                    db.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          else  if (Level3.Level == 3) {
                Level3.stage.close();
                Dashboard db = new Dashboard();
                try {
                    db.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stage.initModality(Modality.APPLICATION_MODAL);
        root.getStyleClass().add("gif");
        root.getChildren().addAll(label,btn5);
        Scene scene =new Scene(root);
        scene.getStylesheets().add(getClass().getResource("gif.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

