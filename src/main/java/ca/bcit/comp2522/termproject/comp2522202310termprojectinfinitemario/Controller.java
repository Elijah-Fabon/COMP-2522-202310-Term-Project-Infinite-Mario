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
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Controller class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class Controller implements Initializable {

    @FXML
    private AnchorPane plane;

    @FXML
    private Rectangle player;

    private double time = 0;
    private double gameTime = 0;
    private Player playerObject;

    private Obstacle obstaclesHandler;
    private Ground groundHandler;
    private final ArrayList<Rectangle> rectangles = new ArrayList<>();
    private final ArrayList<Line> lines = new ArrayList<>();
    private double playerJumpY;


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

        playerObject = new Player(player);
        obstaclesHandler = new Obstacle(plane);
        groundHandler = new Ground(plane);

        load();

        AnimationTimer gameLoop = new AnimationTimer() {
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
            if (playerObject.isPlayerGrounded(lines, plane)) {
                playerObject.jump();
                final int jumpHeight = 300;
                playerJumpY = player.getY() - jumpHeight;
                time = 0;
            }
        }
    }
    private void update() {
        time++;
        gameTime++;
        final double yDeltaDown = 0.06;
        final double yDeltaUp = -65;
        if (playerObject.isJumping()) {
            movePlayerY(yDeltaUp / time);
            if (player.getY() < playerJumpY) {
                playerObject.setJumping(false);
                time = 0;
            }
        }
        if (playerObject.isPlayerGrounded(lines, plane)) {
            time = 0;
        }
        if (!playerObject.isPlayerGrounded(lines, plane) && !playerObject.isJumping()) {
            movePlayerY(yDeltaDown * time);
        }
        obstaclesHandler.moveObstacles(rectangles);
        groundHandler.moveGround(lines);

        if (gameTime % 300 == 0) {
            rectangles.addAll(obstaclesHandler.createObstacles());
        }

        if (gameTime % 150 == 0) {
            lines.addAll(groundHandler.createGround());
        }

        if (playerObject.isPlayerDead(rectangles, plane)) {
            resetGame();
        }
    }
    private void load() {
        System.out.println("Game starting");
        lines.addAll(new ArrayList<>(Arrays.asList(new Line(0, 550, 300, 550),
                new Line(301, 550, 600, 550), new Line(601, 550, 900, 550),
                new Line(901, 550, 1200, 550))));
        plane.getChildren().addAll(lines);
    }

    private void movePlayerY(final double positionChange) {
        player.setY(player.getY() + positionChange);
    }

    private void resetGame() {
        player.setY(0);
        plane.getChildren().removeAll(rectangles);
        rectangles.clear();
        gameTime = 0;
        time = 0;
    }
}
