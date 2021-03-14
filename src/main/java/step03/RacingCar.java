package step03;

public class RacingCar implements Car {
    private static final int MOVABLE_RANGE = 4;
    private int movingRange;

    public RacingCar() {
        movingRange = 0;
    }

    @Override
    public int tryToMove(int randomRange) {
        if (randomRange >= MOVABLE_RANGE) {
            movingRange++;
        }
        return movingRange;
    }

    public int getMovingRange() {
        return movingRange;
    }

}
