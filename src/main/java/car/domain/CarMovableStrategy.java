package car.domain;

public class CarMovableStrategy implements MovableStrategy {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;

    @Override
    public int getRandomNo() {
        return (int) (Math.random() * MAXIMUM_RANDOM_NUMBER);
    }
}
