package racingcar.domain;

import java.util.List;

public class Round {
    private int round;
    private final int finalRound;

    public Round(int finalRound) {
        this.finalRound = finalRound;
    }

    public List<Car> progressRound(RacingCars racingCars) {
        racingCars.run();
        return racingCars.getCars();
    }

    int nextRound() {
        return round = round + 1;
    }

    boolean isLastRound() {
        return finalRound == getRound();
    }

    int getRound() {
        return this.round;
    }
}
