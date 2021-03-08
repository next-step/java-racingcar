package step3.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingUtil {
    public static int createRandomNubmer() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
