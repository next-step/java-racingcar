package step3.domain;

import java.util.*;

public class RacingCar extends Car {

    private static final int UPDATE_POSITION_NUMBER = 1;

    public RacingCar(String carName) {
        super(carName);
    }

    public RacingCar(String carName, int position) {
        super(carName);
        super.position = position;
    }

    @Override
    public int move(int racingCondition, int movementPolicy) {
        if (racingCondition > movementPolicy) {
            return UPDATE_POSITION_NUMBER;
        }
        return ZERO_NUMBER;
    }

    public static int raceStart(Map<String, Car> carInfoMap, String racingCarName, int position) {
        if (carInfoMap.containsKey(racingCarName)) {
            Car racingCar = carInfoMap.get(racingCarName);
            int raceConditionResult = RacingRule.raceCondition();
            position += racingCar.move(raceConditionResult, RacingRule.MOVEMENT_POLICY);
        }
        return position;
    }

}
