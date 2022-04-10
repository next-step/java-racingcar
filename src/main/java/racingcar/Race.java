package racingcar;

import view.ResultView;

import java.util.List;

public class Race {
    private static final int CHECK_CAR_COUNT = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int MAINTAIN_RACE_TIME_FOR_MILLISECOND = 1000;
    private final ResultView resultView;

    public Race(ResultView resultView) {
        this.resultView = resultView;
    }

    public void start(Cars cars, int tryCount) throws InterruptedException {
        if (checkSize(cars.getInstance())) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        for (int count = 0; count < tryCount; count++) {
            cars.addMove(MOVE_CONDITION);
            resultView.printCarsMoveState(cars);
            Thread.sleep(MAINTAIN_RACE_TIME_FOR_MILLISECOND);
        }
    }

    private boolean checkSize(List<Car> cars) {
        return cars.size() <= CHECK_CAR_COUNT;
    }
}
