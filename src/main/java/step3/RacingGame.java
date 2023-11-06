package step3;

import step3.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void play() {
        ResultView.printResultInfoMessage();
        playAllRound();
        ResultView.printWinner(winnerNames());
    }

    private void playAllRound() {
        IntStream.range(0, this.totalRound).forEach(round -> playRound());
    }

    private void playRound() {
        moveAllCar();
        ResultView.printRoundResult(this.cars);
    }

    private void moveAllCar() {
        this.cars.stream().forEach(car -> car.move(randomUtil.random()));
    }

    private List<String> winnerNames() {
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

}
