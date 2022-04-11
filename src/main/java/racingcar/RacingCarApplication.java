package racingcar;

import racingcar.model.Car;
import racingcar.model.CarLocationResult;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.RandomNumberUtil;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {

    private final InputView inputView;

    private final ResultView resultView;

    public RacingCarApplication(
            InputView inputView,
            ResultView resultView
    ) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            List<Car> carList = inputView.inputCars();
            int trialCount = inputView.inputTrialCount();
            List<CarName> winnerCarNames = moveCars(carList, trialCount);
            resultView.printWinners(winnerCarNames);
        } catch (Exception exception) {
            resultView.printErrorMessage(exception.getMessage());
        }
    }

    private List<CarName> moveCars(List<Car> carList, int trialCount) {
        Cars cars = new Cars(carList);
        int carCount = cars.size();
        int nowCount = 0;

        while (isRunning(nowCount, trialCount)) {
            List<Integer> movementList = RandomNumberUtil.generateRandomNumberList(carCount);
            cars.move(movementList);
            List<CarLocationResult> carLocationResults
                    = CarLocationResultConverter.convertIntoCarLocationResult(carList);
            resultView.printCurrentCarMovements(carLocationResults);
            nowCount++;
        }

        return cars.getWinners();
    }

    private boolean isRunning(int nowCount, int trialCount) {
        return nowCount < trialCount;
    }

}
