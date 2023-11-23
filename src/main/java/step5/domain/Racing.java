package step5.domain;

import step5.domain.car.Cars;

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
    private Racing(Cars cars, Referee referee, int tryCount, RacingHistory racingHistory) {
        this.cars = cars;
        this.referee = referee;
        this.tryCount = tryCount;
        this.racingHistory = racingHistory;
    }

    public static Racing defaultOf(String names, Referee referee, int tryCount) {
        return new Racing(Cars.defaultOf(names), referee, tryCount);
    }
    public static Racing defaultOf(Cars cars, Referee referee, int tryCount, RacingHistory racingHistory) {
        return new Racing(cars, referee, tryCount, racingHistory);
    }

    public Racing start() {
        Cars moveCars = this.cars;
        for (int i = 0; i < tryCount; i++) {
            moveCars = moveCars.go(this.referee);
            racingHistory.addHistory(moveCars.makeHistory());
        }

        return Racing.defaultOf(moveCars, this.referee, this.tryCount, this.racingHistory);
    }

    public Cars winnerIs() {
        return this.cars.findFartherestCars();
    }

    public String historyToString() {
        return racingHistory.toString();
    }
}
