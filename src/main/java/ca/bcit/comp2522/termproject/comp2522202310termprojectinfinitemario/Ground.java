package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ground class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class Ground {

    private final AnchorPane plane;
    private final double planeWidth;
    private final Random random = new Random();

    /**
     * Ground constructor.
     * @param newPlane an AnchorPane class object
     */
    public Ground(final AnchorPane newPlane) {
        plane = newPlane;
        planeWidth = 1000;
    }

    /**
     * Returns an array list of lines in the screen.
     * @return an array list of lines
     */
    public ArrayList<Line> createGround() {

        double startXPos = planeWidth;
        final double startEndY = 550;
        final double endXPos = planeWidth + 300;
        int platform = random.nextInt(10 - 1) + 1;
        Line ground;

        if (platform == 3) {
            ground = new Line(startXPos, startEndY - 100, endXPos, startEndY - 100);
        } else if (platform == 6) {
            ground = new Line(startXPos, startEndY - 140, endXPos, startEndY - 140);
        } else if (platform == 9) {
            ground = new Line(startXPos, startEndY - 170, endXPos, startEndY - 170);
        } else {
            ground = new Line(startXPos, startEndY, endXPos, startEndY);
        }

        plane.getChildren().addAll(ground);
        return new ArrayList<>(List.of(ground));
    }

    /**
     * Moves the ground to the left.
     * @param ground an array list of rectangles to move.
     */
    public void moveGround(final ArrayList<Line> ground) {

        ArrayList<Line> outOfScreen = new ArrayList<>();

        for (Line line: ground) {
            moveLine(line);

            if (line.getStartX() <= -300) {
                outOfScreen.add(line);
            }
        }
        ground.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);
    }

    private void moveLine(final Line line) {
        line.setStartX(line.getStartX() + -2.0);
        line.setEndX(line.getEndX() + -2.0);
    }
}
