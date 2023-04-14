package entity;

public class MovableNumberGenerator implements NumberGenerator {

    private static final int MOVABLE_NUMBER = 5;

    @Override
    public int generate() {
        return MOVABLE_NUMBER;
    }
}
