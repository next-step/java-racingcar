package racingcar;

import racingcar.model.Car;
import racingcar.model.Motor;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public static List<Car> initialCars(int carCount, Motor motor) {
        List<Car> carList = new ArrayList<>();

        for (int x = 0; x < carCount; x++) {
            carList.add(new Car(motor));
        }
        return carList;
    }

    public static void startRaceByStep(List<Car> cars) {
        for (Car car : cars) {
            car.run();
        }
    }

}
