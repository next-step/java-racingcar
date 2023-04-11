package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    public static final int RANDOM_NUMBER_LIMIT = 4;

    public static Map<Integer, AtomicInteger> generateCars(int carCount) {
        Map<Integer, AtomicInteger> cars = new HashMap<>();
        for (int i = 0; i < carCount; i++) {
            cars.put(i, new AtomicInteger(0));
        }
        return cars;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static Map<Integer, AtomicInteger> iteratePeriod(int period, Map<Integer, AtomicInteger> cars) {
        System.out.println("실행결과");
        for (int i = 0; i < period; i++) {
            Map<Integer, AtomicInteger> periods = tryPeriod(cars);
        }


        return cars;
    }

    public static boolean isRandomNumberOverFour() {
        return generateRandomNumber() >= RANDOM_NUMBER_LIMIT;
    }

    public static Map<Integer, AtomicInteger> tryPeriod(Map<Integer, AtomicInteger> cars) {
        ResultView.generateUI(cars);
        for (Map.Entry<Integer, AtomicInteger> entry: cars.entrySet()) {
            doForward(entry);
        }

        return cars;
    }

    private static void doForward(Map.Entry<Integer, AtomicInteger> entry) {
        if (isRandomNumberOverFour()) {
            entry.getValue().getAndIncrement();
        }
    }
}
