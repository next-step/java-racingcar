package study.racing.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    public RacingGame(List<String> carNames, RandomNumber randomNumber) {
        this.cars = new Cars(carNames);
        this.randomNumber = randomNumber;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void playRound() {
        cars.playRound(randomNumber);
    }

    public Winners getWinners() {
        return Winners.from(cars.getCars());
    }
}
