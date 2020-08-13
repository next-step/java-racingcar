package step3.domain;

import java.util.*;

public class RacingCar extends Car {

    public static final String CAR_DELIMITER = ",";

    public RacingCar(String carName, int position) {
        super(carName);
        super.position = position;
    }

    @Override
    public int move(int racingCondition, int movementPolicy) {
        if (racingCondition > movementPolicy) {
            return 1;
        }
        return 0;
    }

    public static Map<String, Car> preparationForGame(String racingCarName) {
        Map<String, Car> carInfoMap = new HashMap<>();
        String[] racingCarArray = racingCarName.split(CAR_DELIMITER);

        for (String carName : racingCarArray) {
            ValidationCarName.carNameInvalidException(carName);
            Car car = new RacingCar(carName, 0);
            carInfoMap.put(car.getCarName(), car);
        }
        return carInfoMap;
    }

    public static int raceStart(Map<String, Car> carInfoMap, String racingCarName, int position) {
        if (carInfoMap.containsKey(racingCarName)) {
            Car racingCar = carInfoMap.get(racingCarName);
            int raceConditionResult = RacingRule.raceCondition();
            position += racingCar.move(raceConditionResult, RacingRule.MOVEMENT_POLICY);
        }
        return position;
    }

    public static int findMaxPosition(Map<String, Car> carInfoMap) {
        return carInfoMap.values().stream().max(Comparator.comparingInt(Car::getPosition)).get().position;
    }

}
