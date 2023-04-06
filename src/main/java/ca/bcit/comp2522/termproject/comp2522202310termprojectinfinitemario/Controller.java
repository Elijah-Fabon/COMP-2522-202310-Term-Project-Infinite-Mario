package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    AnimationTimer gameLoop;

    @FXML
    private AnchorPane plane;

    @FXML
    private Rectangle player;

    double time = 0;
    double gameTime = 0;
    private Player playerObject;

    private Obstacle obstaclesHandler;
    private Ground groundHandler;
    ArrayList<Rectangle> rectangles = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

        int jumpHeight = 200;
        playerObject = new Player(player, jumpHeight);
        obstaclesHandler = new Obstacle(plane);
        groundHandler = new Ground(plane);

        load();

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(final long l) {
                update();
            }
        };
        gameLoop.start();
    }

    @FXML
    void pressed(final KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            playerObject.jump();
            time = 0;
        }
    }

    //Called every game frame
    private void update() {
        time++;
        gameTime++;
        double yDelta = 0.02;
        if (!playerObject.isPlayerGrounded(lines, plane)) {
            movePlayerY(yDelta * time);
        }
        obstaclesHandler.moveObstacles(rectangles);
        groundHandler.moveGround(lines);

//        if (gameTime % 500 == 0) {
//            lines.addAll(groundHandler.createGround());
//        }

        if (gameTime % 150 == 0) {
            lines.addAll(groundHandler.createGround());
        }

        if (playerObject.isPlayerDead(rectangles, plane)) {
            resetGame();
        }
    }

    //Everything called once, at the game start
    private void load() {
        System.out.println("Game starting");
        rectangles.addAll(obstaclesHandler.createObstacles());
        lines.addAll(groundHandler.createGround());
    }

    private void movePlayerY(final double positionChange) {
        player.setY(player.getY() + positionChange);
    }

//    private void moveRectangle(final Rectangle rectangle, final double amount) {
//        rectangle.setX(rectangle.getX() + amount);
//    }

    private void resetGame() {
        player.setY(0);
        plane.getChildren().removeAll(rectangles);
        rectangles.clear();
        gameTime = 0;
        time = 0;
    }

//    private void createObstacles() {
//
//        int width = 25;
//        double xPos = plane.getWidth() + 50;
//        double space = 200;
//        double recTopHeight = 100;
//        double recBottomHeight = plane.getHeight() - space - recTopHeight;
//
//        Rectangle rectangleTop = new Rectangle(xPos, 0, width, recTopHeight);
//        Rectangle rectangleBottom = new Rectangle(xPos, recTopHeight + space, width, recBottomHeight);
//
//        rectangles.add(rectangleTop);
//        rectangles.add(rectangleBottom);
//        plane.getChildren().addAll(rectangleTop, rectangleBottom);
//    }
//
//    private void moveObstacles(final ArrayList<Rectangle> obstacles) {
//
//        ArrayList<Rectangle> outOfScreen = new ArrayList<>();
//
//        for (Rectangle rectangle : obstacles) {
//            moveRectangle(rectangle, - 2.00);
//
//            if (rectangle.getX() <= -rectangle.getWidth()) {
//                outOfScreen.add(rectangle);
//            }
//        }
//        obstacles.removeAll(outOfScreen);
//        plane.getChildren().removeAll(outOfScreen);
//    }
}
