package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class CollisionHandler {





    public boolean obstacleCollisionDetection(final ArrayList<Rectangle> obstacles, final Rectangle player) {
        for (Rectangle rectangle: obstacles) {
            if (rectangle.getBoundsInParent().intersects(player.getBoundsInParent())) {
                return true;
            }
        }
        return  false;
    }

    public boolean groundCollisionDetection(final ArrayList<Line> ground, final Rectangle player) {
        for (Line line: ground) {
            if (line.getBoundsInParent().intersects(player.getBoundsInParent())) {
                return true;
            }
        }
        return  false;
    }
}
