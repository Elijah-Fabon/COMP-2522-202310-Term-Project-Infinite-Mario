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
        double xPos = planeWidth - 100;
        double space = 200;
        double recTopHeight = 100;
        double recBottomHeight = planeHeight - space - recTopHeight;

        //                                     x      y   width   height
        Rectangle rectangleBottom = new Rectangle(xPos, recTopHeight + space, width, recBottomHeight);

        plane.getChildren().addAll(rectangleBottom);
        return new ArrayList<>(Arrays.asList(rectangleBottom));
    }


    public void moveObstacles(final ArrayList<Rectangle> obstacles) {

        ArrayList<Rectangle> outOfScreen = new ArrayList<>();

        for (Rectangle rectangle: obstacles) {
            moveRectangle(rectangle, - 2.00);

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
