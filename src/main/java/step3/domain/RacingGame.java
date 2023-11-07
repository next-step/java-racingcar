package step3.domain;

import step3.util.RandomUtil;

import java.util.List;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;

    private RandomUtil randomUtil;
    private Cars cars;
    private int totalRound;

    public RacingGame(List<Car> cars, int numberOfTry) {
        this.randomUtil = new RandomUtil(RANDOM_BOUND);
        this.cars = new Cars(cars);
        this.totalRound = numberOfTry;
    }

    public boolean isEnd(int round) {
        return this.totalRound == round;
    }

    public void playRound() {
        this.cars.move(randomUtil);
    }

    public Cars winners() {
        return this.cars.maxPositionCars();
    }

    public Cars cars() {
        return this.cars;
    }

}
