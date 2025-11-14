package study.racing.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RoundStatus roundStatus;

    public RacingGame(List<String> carNames, RoundCount maxRoundCount) {
        this.cars = new Cars(carNames);
        this.roundStatus = new RoundStatus(maxRoundCount.getValue());
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
