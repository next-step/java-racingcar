package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingCar {

    private static final int RACE_CONDITION_BASE_VALUE = 10;
    private static Random random = new Random();

    public static Map<Integer, Car> preparationForGame(int racingCarNumber) {
        Map<Integer, Car> carInfoMap = new HashMap<>();

        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = new Car(i);
            carInfoMap.put(car.getCarId(), car);
        }
        return carInfoMap;
    }

    public static int raceCondition() {
        return random.nextInt(RACE_CONDITION_BASE_VALUE);
    }

}
