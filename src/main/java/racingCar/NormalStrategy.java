package racingCar;

public class NormalStrategy implements MovableStrategy {

    private static final int BOUNDARY = 4;

    @Override
    public boolean canMove(int value) {
        if (value >= BOUNDARY)
            return true;
        return false;
    }
}
