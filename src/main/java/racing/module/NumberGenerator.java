package racing.module;

public abstract class NumberGenerator {
    private static final int BOUNDARY_NUMBER = 3;

    abstract int getNumber(int boundary);

    boolean canMove(int number) {
        return getNumber(number) > BOUNDARY_NUMBER;
    }
}
