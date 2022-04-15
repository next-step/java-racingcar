package racingcar;

import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.List;

public class RacingCarGame {

    public void gameStart() {
        int carNumber = InputView.carNumber();
        int trialNumber = InputView.trialNumber();

        OutputView.guide();
        racingCarGame(carNumber, trialNumber);
    }

    private void racingCarGame(int carNumber, int trialNumber) {
        List<Car> cars = CarGroup.createCars(carNumber, trialNumber);
        CarGroup carGroup = new CarGroup(cars);
        carGroup.moveCarGroup(trialNumber);
        OutputView.racingResult(trialNumber, carNumber, carGroup.getCarMoveDistanceTrace());
    }
}
