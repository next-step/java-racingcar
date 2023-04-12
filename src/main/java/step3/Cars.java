package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Cars {
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private final Map<Integer, AtomicInteger> cars;
    private int period;

    public Cars(int carCount, int period) {
        validatePositive(carCount, period);
        this.cars = generateCar(carCount);
        this.period = period;
    }

    private Map<Integer, AtomicInteger> generateCar(int carCount) {
        Map<Integer, AtomicInteger> tempCar = new HashMap<>();
        for (int i = 1; i <= carCount; i++) {
            tempCar.put(i, new AtomicInteger(0));
        }
        return tempCar;
    }

    public int getSize() {
        return this.cars.size();
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isOverFour(int number) {
        return number >= RANDOM_NUMBER_LIMIT;
    }

    public int iteratePeriod() {
        int i;
        for (i = 0; i < period; i++) {
            tryPeriod();
        }

        return i;
    }

    public void tryPeriod() {
        ResultView.generateUI(cars);
        for (Integer key: cars.keySet()) {
            doForward(key);
        }
    }

    public void doForward(Integer key) {
        if (isOverFour(randomNumber())) {
            cars.get(key).getAndIncrement();
        }
    }

    public static Cars of(int carCount, int period) {
        return new Cars(carCount, period);
    }

    public void validatePositive(int carCount, int period) {
        if (carCount < 0 || period < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }


}
