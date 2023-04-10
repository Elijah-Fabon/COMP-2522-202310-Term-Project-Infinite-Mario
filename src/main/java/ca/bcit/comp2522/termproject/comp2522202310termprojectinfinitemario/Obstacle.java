package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Obstacle class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class Obstacle {

    private final AnchorPane plane;
    private final double planeWidth;
    private final Random random = new Random();

    /**
     * Obstacle constructor.
     * @param newPlane an AnchorPane class object
     */
    public Obstacle(final AnchorPane newPlane) {
        plane = newPlane;
        planeWidth = 1000;
    }

    /**
     * Returns an array list of rectangles in the screen.
     * @return an array list of rectangles
     */
    public ArrayList<Rectangle> createObstacles() {

        int width = 25;
        double xPos = planeWidth;
        double yPos = 450;
        double height = 100;
        int wall = random.nextInt(20 - 1) + 1;
        Rectangle rectangle;

        if (wall <= 5) {
            rectangle = new Rectangle(xPos, yPos, width, height);
        } else if (wall > 5 && wall <= 10) {
            rectangle = new Rectangle(xPos, yPos - 100, width, height);
        } else if (wall > 10 && wall <= 15) {
            rectangle = new Rectangle(xPos, yPos - 50, width, height);
        } else {
            rectangle = new Rectangle(0, 0, 1, 1);
        }

        plane.getChildren().addAll(rectangle);
        return new ArrayList<>(List.of(rectangle));
    }

    /**
     * Moves obstacles to the left.
     * @param obstacles an array list of rectangles to move.
     */
    public void moveObstacles(final ArrayList<Rectangle> obstacles) {

        ArrayList<Rectangle> outOfScreen = new ArrayList<>();

        for (Rectangle rectangle: obstacles) {
            moveRectangle(rectangle);

            if (rectangle.getX() <= -rectangle.getWidth()) {
                outOfScreen.add(rectangle);
            }
        }
        obstacles.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);
    }

    private void moveRectangle(final Rectangle rectangle) {
        rectangle.setX(rectangle.getX() - 3.0);
    }

}
