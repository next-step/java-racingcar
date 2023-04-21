package step3;

import step3.model.Cars;
import step3.view.ResultView;

public class RacingProcess {
    private final int carCount;
    private final int periodCount;

    public RacingProcess(int carCount, int periodCount) {
        countValidation(carCount);
        countValidation(periodCount);

        this.carCount = carCount;
        this.periodCount = periodCount;
    }

    public void racingStart() {
        Cars cars = Cars.generateCars(carCount);
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
    }

    private void countValidation(int count) {
        if (count < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
