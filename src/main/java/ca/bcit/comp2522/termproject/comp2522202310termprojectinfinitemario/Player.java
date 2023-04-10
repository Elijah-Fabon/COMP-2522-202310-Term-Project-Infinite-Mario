package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Player class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class Player {

    private static final boolean DEFAULT_JUMP = false;
    private boolean jumping;
    private final Rectangle player;
    private final CollisionHandler collisionHandler = new CollisionHandler();

    /**
     * Player constructor.
     * @param newPlayer a rectangle class object.
     */
    public Player(final Rectangle newPlayer) {
        player = newPlayer;
        jumping = DEFAULT_JUMP;
    }

    /**
     * Sets player.jumping to true.
     */
    public void jump() {
        jumping = true;
    }

    /**
     * Checks if the player collides with a rectangle on screen.
     * @param obstacles an array list of rectangles.
     * @param plane an anchorpane class object.
     * @return true if the player collides with a rectangle, false if not.
     */
    public boolean isPlayerDead(final ArrayList<Rectangle> obstacles, final AnchorPane plane) {
        double playerY = player.getLayoutY() + player.getY();

        if (collisionHandler.obstacleCollisionDetection(obstacles, player)) {
            return  true;
        }

        return playerY >= plane.getHeight();
    }

    /**
     * Checks if the player is touching the ground or not.
     * @param ground an array list of lines
     * @param plane an anchorplane class object
     * @return true if the player is touching ground, false if not.
     */
    public boolean isPlayerGrounded(final ArrayList<Line> ground, final AnchorPane plane) {
        double playerY = player.getLayoutY() + player.getY();

        if (collisionHandler.groundCollisionDetection(ground, player)) {
            return  true;
        }

        return playerY >= plane.getHeight();
    }

    /**
     * Checks if the player is jumping.
     * @return true if the player is jumping, false if not
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * Sets the jumping status of the player.
     * @param jumping a boolean
     */
    public void setJumping(final boolean jumping) {
        this.jumping = jumping;
    }
}
