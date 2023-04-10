package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Collision Handler class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class CollisionHandler {

    /**
     * Checks if the player collides with a rectangle.
     * @param obstacles an array list of rectangles
     * @param player a rectangle class object
     * @return true if the player collides with a rectangle, false if not.
     */
    public boolean obstacleCollisionDetection(final ArrayList<Rectangle> obstacles, final Rectangle player) {
        for (Rectangle rectangle: obstacles) {
            if (rectangle.getBoundsInParent().intersects(player.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the player collides with a line.
     * @param ground an array list of lines
     * @param player a line class object
     * @return true if the player collides with a line, false if not.
     */
    public boolean groundCollisionDetection(final ArrayList<Line> ground, final Rectangle player) {
        for (Line line: ground) {
            if (line.getBoundsInParent().intersects(player.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}
