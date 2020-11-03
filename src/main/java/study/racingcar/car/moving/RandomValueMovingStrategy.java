package study.racingcar.car.moving;

import study.racingcar.car.Car;

import java.util.Random;

public class RandomValueMovingStrategy implements CarMovingStrategy{

    private static RandomValueMovingStrategy instance = new RandomValueMovingStrategy();

    private static Random random = new Random();

    public static RandomValueMovingStrategy getInstance() {
        return instance;
    }

    @Override
    public MovingSeed getMovingSeed() {
        return MovingSeed.newSeed(random.nextInt(10));
    }
}
