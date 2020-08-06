package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingCar {

    public static Map<Integer, Car> preparationForGame(int racingCarNumber) {
        Map<Integer, Car> carInfoMap = new HashMap<>();

        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = new Car(i);
            carInfoMap.put(car.getCarId(), car);
        }
        return carInfoMap;
    }

    public static int raceCondition() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
