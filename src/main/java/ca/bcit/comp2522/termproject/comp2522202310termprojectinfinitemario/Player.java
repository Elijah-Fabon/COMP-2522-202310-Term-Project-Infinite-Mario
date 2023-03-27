package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Player extends Box implements Moves {

    private static final boolean DEFAULT_STATUS = true;

    private boolean alive;

    public Player(final double newX,
                  final double newY) {
        super(newX, newY);
        alive = DEFAULT_STATUS;
    }

    @Override
    public void move() {

    }
}
