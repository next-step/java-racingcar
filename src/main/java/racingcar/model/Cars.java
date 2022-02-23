package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomGenerator;

public class Cars {

    public Cars() {

    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
        return racingCars;
    }

    public List<Car> moveForwardByCount(List<Car> racingCars) {
        List<Car> racingHistory = new ArrayList<>();
        for (Car racingCar : racingCars) {
            racingCar.moveForward(RandomGenerator.generateRandomNumber());
            racingHistory.add(racingCar);

        }
        return racingHistory;
    }

}
