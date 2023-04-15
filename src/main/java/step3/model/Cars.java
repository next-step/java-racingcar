package step3.model;

import java.util.List;
import java.util.Random;

public class Cars {
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void goForward(int period) {
        for (int i = 0; i <= period; i++) {
            for (Car car : cars) {
                Random random = new Random();
                int randomValue = random.nextInt();

                if (randomValue >= RANDOM_NUMBER_LIMIT) {
                    car.increaseDistance();
                }
            }
        }
    }
}
