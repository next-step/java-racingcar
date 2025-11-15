package study.racing.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final Round round;

    public RacingGame(String carNames, int roundCount) {
        this(Arrays.asList(carNames.split(",")), roundCount);
    }

    public RacingGame(List<String> names, Round round) {
        this(Cars.from(names), round);
    }

    public RacingGame(List<String> carNames, int roundCount) {
        this(Cars.from(carNames), new Round(roundCount));
    }

    public RacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void playRound(RandomNumber randomNumber) {
        round.decrease();
        cars.playRound(randomNumber);
    }

    public Winners getWinners() {
        return cars.getWinners();
    }

    public boolean hasNextRound() {
        return round.hasRemaining();
    }
}
