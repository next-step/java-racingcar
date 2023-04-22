package java_racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private static final Random random = new Random();

    void doRacing(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = random.nextInt(8) + 1;
            car.race(randomNumber);
            ResultView.printSingleRace(car.raceResult());
        }
    }

    List<Car> readyForRacingCar(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}