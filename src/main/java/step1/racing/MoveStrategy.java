package step1.racing;

public class MoveStrategy implements Moveable {
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final int MOVE_NUMBER_BOUNDARY = 4;

    private RandomNumberGenerator<Integer> randomNumberGenerator;

    public MoveStrategy(RandomNumberGenerator<Integer> randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMoveable() {
        return randomNumberGenerator.gacha(RANDOM_NUMBER_BOUNDARY) > MOVE_NUMBER_BOUNDARY;
    }
}
