package step3.model;

import java.util.List;
import java.util.Random;

public class Cars {
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void goForward() {
        checkForwardCondition();

    }

    public List<Car> getCars() {
        return this.cars;
    }


    private void checkForwardCondition() {
        for (Car car : cars) {
            if (isOverLimit(generateRandomNumber())) {
                car.increaseDistance();
            }
        }
    }

    private boolean isOverLimit(int randomValue) {
        return randomValue >= RANDOM_NUMBER_LIMIT;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
