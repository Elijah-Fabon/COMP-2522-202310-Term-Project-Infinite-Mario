package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Enemy extends Obstacle implements Dangerous, Moves {

    public Enemy(final double newX,
                 final double newY) {
        super(newX, newY);
    }

    @Override
    public void kill(final Player player) {

    }

    @Override
    public void move() {

    }
}
