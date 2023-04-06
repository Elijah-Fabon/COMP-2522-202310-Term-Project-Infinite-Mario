package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Player {

    private static final boolean DEFAULT_JUMP = false;
    private boolean jumping;
    private Rectangle player;
    private int jumpHeight;
    CollisionHandler collisionHandler = new CollisionHandler();

    public Player(final Rectangle newPlayer, final int newJumpHeight) {
        player = newPlayer;
        jumpHeight = newJumpHeight;
    }

    public void jump() {
        double movement = -jumpHeight;
        if (player.getLayoutY() + player.getY() <= jumpHeight) {
            movement = -(player.getLayoutY() + player.getY());
        }

        movePlayerY(movement);
    }

    public void movePlayerY(final double positionChange) {
        player.setY(player.getY() + positionChange);
    }

    public boolean isPlayerDead(final ArrayList<Rectangle> obstacles, final AnchorPane plane) {
        double playerY = player.getLayoutY() + player.getY();

        if (collisionHandler.obstacleCollisionDetection(obstacles, player)) {
            return  true;
        }

        return playerY >= plane.getHeight();
    }

    public boolean isPlayerGrounded(final ArrayList<Line> ground, final AnchorPane plane) {
        double playerY = player.getLayoutY() + player.getY();

        if (collisionHandler.groundCollisionDetection(ground, player)) {
            return  true;
        }

        return playerY >= plane.getHeight();
    }

}
