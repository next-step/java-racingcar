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

        for (int i = 1; i <= racingCarNumber; i++) {
            Car car = new RacingCar(i);
            carInfoMap.put(car.getCarId(), car);
        }
        return carInfoMap;
    }


}
