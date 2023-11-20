package step5.domain;

import step5.domain.car.Cars;

import java.util.List;

public class Racing {
    private final Cars  cars;
    private final Referee referee;
    private final int tryCount;
    private final RacingHistory racingHistory;

    private Racing(Cars cars, Referee referee, int tryCount) {
        this.cars = cars;
        this.referee = referee;
        this.tryCount = tryCount;
        this.racingHistory = RacingHistory.defaultOf();
    }

    public static Racing defaultOf(String names, Referee referee, int tryCount) {
        return new Racing(Cars.defaultOf(names), referee, tryCount);
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            this.cars.go(this.referee);
            racingHistory.addHistory(this.cars.makeHistory());
        }
    }

    public Cars winnerIs() {
        return this.cars.voteWinner();
    }

    public String historyToString() {
        return racingHistory.toString();
    }
}
