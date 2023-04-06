package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Obstacle {

    private final AnchorPane plane;
    private final double planeHeight;
    private final double planeWidth;
    private final Random random = new Random();

    public Obstacle(final AnchorPane newPlane) {
        plane = newPlane;
        planeHeight = 600;
        planeWidth = 1000;
    }

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
        return new ArrayList<>(Arrays.asList(rectangle));
    }


    public void moveObstacles(final ArrayList<Rectangle> obstacles) {

        ArrayList<Rectangle> outOfScreen = new ArrayList<>();

        for (Rectangle rectangle: obstacles) {
            moveRectangle(rectangle, -3.00);

            if (rectangle.getX() <= -rectangle.getWidth()) {
                outOfScreen.add(rectangle);
            }
        }
        obstacles.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);
    }

    private void moveRectangle(final Rectangle rectangle, final double amount) {
        rectangle.setX(rectangle.getX() + amount);
    }

}
