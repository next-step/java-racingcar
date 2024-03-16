package racingcar;

import racingcar.model.Car;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INIT_CAR_DISTANCE = 0;

    private static final RacingCarGameService instance = new RacingCarGameService();

    private RacingCarGameService() {

    }

    public static RacingCarGameService getInstance() {
        return instance;
    }

    public void gameLogic(String nameOfCars, int numberOfAttempt) {
        List<Car> cars = initCars(nameOfCars);

        for (int i = 0; i < numberOfAttempt; i++) {
            RacingCarGameRule.getInstance().moveCars(cars);
            ResultView.getInstance().printMove(cars);
        }

        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        ResultView.getInstance().printRacingcarWinners(winners);
    }

    public List<Car> initCars(String nameOfCars) {
        String[] names = getCarNamesSplit(nameOfCars);
        List<Car> cars = new ArrayList<>(names.length);

        for (String name: names) {
            cars.add(new Car(name, INIT_CAR_DISTANCE));
        }

        return cars;
    }

    private static String[] getCarNamesSplit(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

}
