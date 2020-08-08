package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class RacingCar extends Car {

    public RacingCar(int carId) {
        super(carId);
    }

    @Override
    public boolean move(int racingCondition, int movementPolicy) {
        if (racingCondition > movementPolicy) {
            return accelerate();
        }
        return brake();
    }

    public static Map<Integer, Car> preparationForGame(int racingCarNumber) {
        Map<Integer, Car> carInfoMap = new HashMap<>();

        for (int carId = 1; carId <= racingCarNumber; carId++) {
            Car car = new RacingCar(carId);
            carInfoMap.put(car.getCarId(), car);
        }
        return carInfoMap;
    }

    public static boolean receStart(Car racingCar, int racingCarNumber) {
        boolean result = false;
        if (racingCar.getCarId() == racingCarNumber) {
            int raceConditionResult = RacingRule.raceCondition();
            result = racingCar.move(raceConditionResult, RacingRule.MOVEMENT_POLICY);
        }
        return result;
    }


}
