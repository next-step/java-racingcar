package racingcar;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVE_BOUNDARY_NUMBER = 4;
    private static final RandomGenerator randomGenerator = new RandomGenerator();

    @Override
    public boolean movable() {
        return randomGenerator.getOneNumberFrom0to9() >= MOVE_BOUNDARY_NUMBER;
    }
}