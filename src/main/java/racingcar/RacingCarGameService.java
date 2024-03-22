package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {
    private static final int INIT_CAR_DISTANCE = 0;

    private static final RacingCarGameService instance = new RacingCarGameService();

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    private RacingCarGameService() {

    }

    public static RacingCarGameService getInstance() {
        return instance;
    }

    public void gameLogic() {
        String[] nameOfCars = inputView.inputNamesOfCar();
        int numberOfAttempt = inputView.inputNumberOfAttempt();

        Cars cars = new Cars(initCars(nameOfCars));

        for (int i = 0; i < numberOfAttempt; i++) {
            cars.moveCars();
            resultView.printMove(cars);
        }

        List<Car> winners = cars.getWinnerCars();
        resultView.printRacingcarWinners(winners);
    }

    public List<Car> initCars(String[] names) {
        List<Car> cars = new ArrayList<>(names.length);

        for (String name : names) {
            cars.add(new Car(name, INIT_CAR_DISTANCE));
        }

        return cars;
    }

}
