package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSupport {

    static List<Car> prepareCar(Integer carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    static List<Car> raceEachCar(List<Car> preparedCar) {
        for (int j = 0; j < preparedCar.size(); j++) {
            moveByRaceRule(isRandomGreaterThanThree(), preparedCar, j);
        }

        return preparedCar;
    }

    static List<Car> moveByRaceRule(Boolean isMove, List<Car> preparedCars, Integer j) {
        if (isMove) {
            preparedCars.get(j).moveForward();
            return preparedCars;
        }

        return preparedCars;
    }

    private static Boolean isRandomGreaterThanThree() {
        final int isMove = new Random().nextInt(10);

        return isMove> 3;
    }
}
