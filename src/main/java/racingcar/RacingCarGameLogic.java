package racingcar;

import racingcar.model.Car;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGameLogic {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INIT_CAR_DISTANCE = 0;

    private static final RacingCarGameLogic instance = new RacingCarGameLogic();

    private RacingCarGameLogic() {

    }

    public static RacingCarGameLogic getInstance() {
        return instance;
    }

    public void gameLogic(String nameOfCars, int numberOfAttempt) {
        List<Car> cars = initCars(nameOfCars);

        for (int i = 0; i < numberOfAttempt; i++) {
            RacingCarGameRule.getInstance().moveCars(cars);
            ResultView.getInstance().printMove(cars);
            ResultView.getInstance().printLineBreak();
        }

        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        ResultView.getInstance().printRacingcarWinners(winners);
    }

    public List<Car> initCars(String nameOfCars) {
        String[] names = getCarNamesSplit(nameOfCars);
        List<Car> cars = new ArrayList<>(names.length);

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i],INIT_CAR_DISTANCE));
        }

        return cars;
    }

    private static String[] getCarNamesSplit(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

}
