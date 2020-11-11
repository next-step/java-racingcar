package racingcar.domain;

import java.util.List;

import racingcar.view.ResultView;

public class Round {
    private int round;
    private final int finalRound;

    public Round(int finalRound) {
        this.finalRound = finalRound;
    }

    public void progressRound(RacingCars racingCars) {
        while (!isLastRound()) {
            racingCars.run();
            List<Car> cars = racingCars.getCars();
            ResultView.printPositionResult(cars);
        }
        ResultView.printNamesOfWinnerCarsResult(racingCars.getNamesOfWinnerCars());
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
