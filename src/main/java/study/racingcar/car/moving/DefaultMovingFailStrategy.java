package study.racingcar.car.moving;

public class DefaultMovingFailStrategy implements CarMovingStrategy{

    private static DefaultMovingFailStrategy instance = new DefaultMovingFailStrategy();

    private DefaultMovingFailStrategy() {

    }

    public static DefaultMovingFailStrategy getInstance() {
        return instance;
    }

    @Override
    public MovingSeed getMovingSeed() {
        return MovingSeed.newSeed(0);
    }
}
