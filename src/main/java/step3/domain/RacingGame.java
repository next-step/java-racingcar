package step3.domain;

import step3.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private static final int DEFAULT_POSITION = 0;

    private RandomUtil randomUtil;
    private List<Car> cars;
    private int totalRound;

    public RacingGame(List<Car> cars, int numberOfTry) {
        this.randomUtil = new RandomUtil(RANDOM_BOUND);
        this.cars = cars;
        this.totalRound = numberOfTry;
    }

    public boolean isEnd(int round) {
        return this.totalRound == round;
    }

    public void playRound() {
        this.cars.stream()
            .forEach(car -> car.move(randomUtil.random()));
    }

    public List<String> winnerNames() {
        return this.cars.stream()
            .filter(car -> isMaxPosition(car))
            .map(Car::name)
            .collect(Collectors.toList());
    }

    private boolean isMaxPosition(Car car) {
        return maxPosition() == car.position();
    }

    private int maxPosition() {
        return this.cars.stream()
            .mapToInt(Car::position)
            .max()
            .orElse(DEFAULT_POSITION);
    }

    public List<Car> cars() {
        return this.cars;
    }

}
