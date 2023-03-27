package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

public class Pit extends Obstacle {

    public Pit(final double newX,
                 final double newY) {
        super(newX, newY);
    }

    private class Spikes extends Obstacle implements Dangerous {

        public Spikes(final double newX, final double newY) {
            super(newX, newY);
        }

        @Override
        public void kill(final Player player) {

        }
    }
}
