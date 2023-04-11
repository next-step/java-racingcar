package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    public static final int RANDOM_NUMBER_LIMIT = 4;
    public static Map<Integer, AtomicInteger> generateCars(int carCount) {
        Map<Integer, AtomicInteger> cars = new HashMap<>();
        for (int i = 1; i <= carCount; i++) {
            cars.put(i, new AtomicInteger(1));
        }
        return cars;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
