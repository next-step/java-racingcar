package refactoringracingcar.domain;

public class MovingStrategy {

    private static final int MOVE_DISCRIMINANT = 4;
    private static final int RANDOM_LIMIT = 10;

    public boolean discriminateMovement() {
        return randomMovement() >= MOVE_DISCRIMINANT;
    }

    private int randomMovement() {
        return (int) (Math.random() * RANDOM_LIMIT);
    }
}
