package study.racing.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RoundStatus roundStatus;

    public RacingGame(String carNames, int roundCount) {
        this(Arrays.asList(carNames.split(",")), new RoundCount(roundCount));
    }

    public RacingGame(List<String> carNames, RoundCount maxRoundCount) {
        this(Cars.from(carNames), new RoundStatus(maxRoundCount.getValue()));
    }

    public RacingGame(Cars cars, RoundStatus roundStatus) {
        this.cars = cars;
        this.roundStatus = roundStatus;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void playRound(RandomNumber randomNumber) {
        cars.playRound(randomNumber);
        roundStatus.next();
    }

    public Winners getWinners() {
        return cars.getWinners();
    }

    public boolean hasNextRound() {
        return roundStatus.hasNextRound();
    }
}
