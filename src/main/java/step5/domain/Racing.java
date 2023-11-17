package step5.domain;

import step5.domain.car.Cars;

public class Racing {
    private final Cars  cars;
    private final Referee referee;
    private final int tryCount;
    private Racing(Cars cars, Referee referee, int tryCount) {
        this.cars = cars;
        this.referee = referee;
        this.tryCount = tryCount;
    }

    public static Racing defaultOf(String names, Referee referee, int tryCount) {
        return new Racing(Cars.defaultOf(names), referee, tryCount);
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            this.cars.go(this.referee);
        }
    }

    public Winners winnerIs() {
        return this.cars.voteWinner();
    }
}
