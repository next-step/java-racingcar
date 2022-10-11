package racingcar;

import racingcar.contorller.RaceController;
import racingcar.model.Car;
import racingcar.model.RaceInput;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static void main(String[] args) {
        RaceInput racingInput = new RaceInput();
        List<Car> cars = generateCars(racingInput.getNumberOfCar());
        RaceController raceController = new RaceController(cars, racingInput.getTryCount());
        raceController.startRacing();
    }

    public static List<Car> generateCars(int numberOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
