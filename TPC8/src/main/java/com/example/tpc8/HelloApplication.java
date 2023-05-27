package com.example.tpc8;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600, Color.LIGHTSTEELBLUE);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("TPC 8 - Trabalhar com Scene");


        Text texto = new Text("TPC 8");
        texto.getStyleClass().add("text");

        Line linha = new Line(200, 80, 480, 310);
        linha.getStyleClass().add("line");

        Rectangle retangulo = new Rectangle(77, 150, 100, 100);
        retangulo.getStyleClass().add("rectangle");

        Polygon triangulo = new Polygon();
        triangulo.getPoints().addAll(
                130.0, 250.0,
                250.0, 350.0,
                150.0, 350.0);
        double x = -((200 - 300) / 2.0);
        double y = -((200 - 300) / 2.0);
        triangulo.getStyleClass().add("triangle");
        triangulo.setTranslateX(x);
        triangulo.setTranslateX(y);

        Circle circulo = new Circle(350, 400, 50);
        circulo.getStyleClass().add("circle");

        Image imagem = new Image(getClass().getResourceAsStream("/com/example/tpc8/logo.png"));
        ImageView logo = new ImageView(imagem);
        logo.getStyleClass().add("logo");
        logo.setX(150);
        logo.setY(500);

        root.getChildren().addAll(texto, linha, retangulo, triangulo, circulo, logo);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}