package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ground {

    private final AnchorPane plane;
    private final double planeWidth;
    private final Random random = new Random();

    public Ground(final AnchorPane plane) {
        this.plane = plane;
        this.planeWidth = 1000;
    }

    public ArrayList<Line> createGround() {

        double startXPos = planeWidth;
        double startEndY = 550;
        double endXPos = planeWidth + 300;
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
        return new ArrayList<>(Arrays.asList(ground));
    }


    public void moveGround(final ArrayList<Line> ground) {

        ArrayList<Line> outOfScreen = new ArrayList<>();

        for (Line line: ground) {
            moveLine(line, -2.00);

            if (line.getStartX() <= -300) {
                outOfScreen.add(line);
            }
        }
        ground.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);
    }

    private void moveLine(final Line line, final double amount) {
        line.setStartX(line.getStartX() + amount);
        line.setEndX(line.getEndX() + amount);
    }
}
