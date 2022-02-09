package racing.domain.startegy;

public class RandomMovingStrategy implements MovingStrategy{

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    @Override
    public int moving() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }
}
