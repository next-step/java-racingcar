package carracing.controller;

import carracing.model.Car;
import carracing.model.CarRacing;
import carracing.model.RandomNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int CAR_POSITION_INITIAL_VALUE = 0;
    private List<Car> cars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private CarRacing carRacing;

    public RacingGame(String carNameInput) {
        List<String> CarNames = Arrays.asList(carNameInput.split(CAR_NAME_SEPARATOR));
        for (String carName : CarNames) {
            cars.add(new Car(carName, CAR_POSITION_INITIAL_VALUE));
        }
        carRacing = new CarRacing(cars);
    }

    public void race(Car car) {
        car.move(RandomNumber.createRandomNumber());
        winners = carRacing.makeWinners();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
