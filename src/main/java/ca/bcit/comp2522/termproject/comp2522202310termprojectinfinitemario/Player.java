package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Player extends Box implements Moves {

    private static final boolean DEFAULT_STATUS = true;

    private boolean alive;

    public Player(final double newX,
                  final double newY) {
        super(newX, newY);
        alive = DEFAULT_STATUS;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    @Override
    public void move() {

    }
}
