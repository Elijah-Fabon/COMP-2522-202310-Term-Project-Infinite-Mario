package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Wall extends Obstacle implements Dangerous, Moves {

    public Wall(final double newX,
                 final double newY,
                final ObstacleSize newObstacleSize) {
        super(newX, newY, newObstacleSize);
    }

    @Override
    public void kill(final Player player) {

    }

    @Override
    public void move() {

    }
}
