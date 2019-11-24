package racingcarNew;

import racingcarNew.domain.Car;
import racingcarNew.domain.Cars;
import racingcarNew.domain.RacingHistory;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final String INPUT_TEXT_SPLIT_REGEX = ",";
    private int racingLap;
    private Cars cars;

    public RacingGame(String carNames, int racingLap) {
        cars = generateCars(carNames);
        this.racingLap = racingLap;
    }

    private Cars generateCars(String carNames) {
        String[] names = carNames.split(INPUT_TEXT_SPLIT_REGEX);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, DEFAULT_CAR_POSITION));
        }
        return new Cars(cars, DEFAULT_CAR_POSITION);
    }

    public Cars getRacingCars() {
        return cars;
    }

    public RacingHistory race() {

        List<Cars> carsHistory = new ArrayList<>();
        for (int i = 0; i < racingLap; i++) {
            carsHistory.add(cars.moveAll());
        }
        return new RacingHistory(carsHistory);
    }
}
