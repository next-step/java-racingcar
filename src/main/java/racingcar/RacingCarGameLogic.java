package racingcar;

import racingcar.model.Car;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGameLogic {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int INIT_CAR_DISTANCE = 0;

    private static RacingCarGameLogic instance = new RacingCarGameLogic();

    private RacingCarGameLogic() {

    }

    public static RacingCarGameLogic getInstance() {
        return instance;
    }

    public void gameLogic(String nameOfCars, int numberOfAttempt) {
        List<Car> cars = initCars(nameOfCars);
        IntStream.range(0, numberOfAttempt).forEach(i -> RacingCarGameRule.getInstance().moveCars(cars));
        List<Car> winners = RacingCarGameRule.getInstance().getWinnerCars(cars);
        ResultView.getInstance().printRacingcarWinners(winners);
    }

    public List<Car> initCars(String nameOfCars) {
        String[] names = getCarNamesSplit(nameOfCars);
        List<Car> cars = new ArrayList<>(names.length);
        IntStream.range(0, names.length).forEach(i -> cars.add(new Car(names[i],INIT_CAR_DISTANCE)));
        return cars;
    }

    private static String[] getCarNamesSplit(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }
    
}
