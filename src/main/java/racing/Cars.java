package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final Random random = new Random();
    public static final int UPPER_BOUND = 10;
    private final List<Car> cars;

    private Cars(int count) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }

    public static Cars init(int count) {
        return new Cars(count);
    }

    public void tryToMoveAllCars() {
        cars.forEach(car -> {
            int randomValue = random.nextInt(UPPER_BOUND);
            car.goForward(randomValue);
        });
    }

    public void showPositionsOfCars() {
        cars.forEach(car -> System.out.println(car.positionInfoString()));
        System.out.println();
    }
}
