package refactoringracingcar.domain;

public class MovingStrategy {

    private final static int MOVE_DISCRIMINANT = 4;
    private final static int RANDOM_LIMIT = 10;

    public int moveCarUnit() {
        if (discriminateMovement()) {
            return 1;
        }
        return 0;
    }

    private boolean discriminateMovement() {
        return randomMovement() >= MOVE_DISCRIMINANT;
    }

    private int randomMovement() {
        return (int) (Math.random() * RANDOM_LIMIT);
    }
}
