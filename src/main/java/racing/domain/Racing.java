package racing.domain;

import racing.view.OutputView;

public class Racing {
    private final int tryTimes;
    private final Cars cars;

    public Racing(int movingCount, Cars cars) {
        this.tryTimes = movingCount;
        this.cars = cars;
    }

    public void start() {
        OutputView.racingResult();
        for (int i = 0; i < tryTimes; i++) {
            cars.move();
            OutputView.racingStatus(cars);
        }
    }

    public void end() {
        OutputView.racingEnd(ChooseTheWinner());
    }

    public RaceWinner ChooseTheWinner() {
        return new RaceWinner(cars);
    }
}
