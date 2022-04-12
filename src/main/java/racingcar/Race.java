package racingcar;

import view.ResultView;

public class Race {
    private final ResultView resultView;

    public Race(ResultView resultView) {
        this.resultView = resultView;
    }

    public int start(int carCount, int tryCount) {
        int raceCount = 0;
        Cars cars = Cars.builder()
                .carCount(carCount)
                .raceCondition(new RaceCondition())
                .build();

        if (!cars.checkSize()) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        for (int count = 0; count < tryCount; count++) {
            cars.addMove();
            resultView.printCarsMoveState(cars);
            raceCount++;
        }

        return raceCount;
    }

}
