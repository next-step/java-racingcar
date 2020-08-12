package step3.domain;

import java.util.*;

public class RacingCar extends Car {

    private static final int CAR_NAME_LENGTH_POLICY = 5;

    public RacingCar(String carName, int position) {
        super(carName);
        super.position = position;
    }

    @Override
    public boolean canMove(int racingCondition, int movementPolicy) {
        if (racingCondition > movementPolicy) {
            return canAccelerate();
        }
        return canBrake();
    }

    public static Map<String, Car> preparationForGame(String racingCarName) {
        Map<String, Car> carInfoMap = new HashMap<>();
        String[] racingCarArray = racingCarName.split(",");

        for (String carName : racingCarArray) {
            carNameInvalidException(carName);
            Car car = new RacingCar(carName, 0);
            carInfoMap.put(car.getCarName(), car);
        }
        return carInfoMap;
    }

    public static void carNameInvalidException(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_POLICY) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static int updatePosition(boolean raceResult) {
        if (raceResult) {
            return 1;
        }
        return 0;
    }

    public static boolean isRaceStart(Map<String, Car> carInfoMap, String racingCarName) {
        boolean result = false;

        if (carInfoMap.containsKey(racingCarName)) {
            Car racingCar = carInfoMap.get(racingCarName);
            int raceConditionResult = RacingRule.raceCondition();
            result = racingCar.canMove(raceConditionResult, RacingRule.MOVEMENT_POLICY);
        }
        return result;
    }

    public static int findMaxPosition(Map<String, Car> carInfoMap) {
        return carInfoMap.values().stream().max(Comparator.comparingInt(Car::getPosition)).get().position;
    }

    public static List<String> racingCarWinner(Map<String, Car> carInfoMap, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (String key : carInfoMap.keySet()) {
            Car car = carInfoMap.get(key);
            verifyWinner(winners, car, maxPosition);
        }
        return winners;
    }

    public static List<String> verifyWinner(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getCarName());
        }
        return winners;
    }

}
