package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public abstract class Obstacle extends Box {

    private ObstacleSize obstacleSize;

    public Obstacle(final double newX,
                    final double newY,
                    final ObstacleSize newObstacleSize) {
        super(newX, newY);
        obstacleSize = newObstacleSize;
    }

}
