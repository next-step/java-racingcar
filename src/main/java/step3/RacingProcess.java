package step3;

import step3.model.Cars;
import step3.view.ResultView;

public class RacingProcess {
    private final String carName;
    private final int periodCount;

    public RacingProcess(String carNames, int periodCount) {
        carNameValidation(carNames);
        countValidation(periodCount);

        this.carName = carNames;
        this.periodCount = periodCount;
    }

    public void racingStart() {
        Cars cars = Cars.generateCars(carName);
        ResultView resultView = new ResultView();

        resultView.startUI();
        resultView.drawing(cars.getCars());
        iterateRacing(cars, resultView);
    }

    private void iterateRacing(Cars cars, ResultView resultView) {
        for (int i = 1; i < periodCount; i++) {
            cars.checkForwardConditionAndGo();
            resultView.drawing(cars.getCars());
        }

        resultView.winner(cars.getWinner());
    }

    private void countValidation(int count) {
        if (count < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private void carNameValidation(String carNames) {
        if (carNames == null || "".equals(carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요");
        }
    }
}
