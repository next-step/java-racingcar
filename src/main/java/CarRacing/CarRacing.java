package CarRacing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CarRacing {

    public static final int BOUND = 10;
    public static final int MIN_MOVE_VALUE = 4;

    private static final Random random = new Random();

    public boolean shouldMove(int randomValue) {
        return randomValue >= MIN_MOVE_VALUE;
    }

    public Map<Integer, Integer> race(int carNums, int moveNums) {
        Map<Integer, Integer> carsMap = initCarsMap(carNums);

        return carsMap;
    }

    private static Map<Integer, Integer> initCarsMap(int carNums) {
        Map<Integer, Integer> carsMap = new HashMap<>();

        for(int i = 1; i<= carNums; i++) {
            carsMap.put(i, 0);
        }
        return carsMap;
    }
}
