package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingCarGameService {
    private static final RacingCarGameService instance = new RacingCarGameService();
    private static final int MOVE_CONDITION = 3;

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    private RacingCarGameService() {

    }

    public static RacingCarGameService getInstance() {
        return instance;
    }

    public void gameLogic() {
        List<String> nameOfCars = inputView.inputNamesOfCar();
        int numberOfAttempt = inputView.inputNumberOfAttempt();

        Cars cars = Cars.of(nameOfCars);

        for (int i = 0; i < numberOfAttempt; i++) {
            cars.moveCars(() -> RandomManager.getInstance().getRandomValue() > MOVE_CONDITION);
            resultView.printMove(cars);
        }

        List<Car> winners = cars.getWinnerCars();
        resultView.printRacingcarWinners(winners);
    }

}
