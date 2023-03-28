package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Enemy extends Obstacle implements Dangerous, Moves {

    public Enemy(final double newX,
                 final double newY,
                 final ObstacleSize newObstacleSize) {
        super(newX, newY, newObstacleSize);
    }

    @Override
    public void kill(final Player player) {
        player.setAlive(false);
    }

    @Override
    public void move() {

    }
}
