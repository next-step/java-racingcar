package study.racingcar.car.moving;

public class DefaultMovingSuccessStrategy implements CarMovingStrategy {

    private static DefaultMovingSuccessStrategy instance = new DefaultMovingSuccessStrategy();

    private DefaultMovingSuccessStrategy() {

    }

    public static DefaultMovingSuccessStrategy getInstance() {
        return instance;
    }

    @Override
    public MovingSeed getMovingSeed() {
        return MovingSeed.newSeed(100);
    }
}
