package car;

import java.util.List;
import java.util.Random;

class Movement {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVEMENT_THRESHOLD = 4;

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = new Random().nextInt(RANDOM_BOUND);
        if (randomNumber >= MOVEMENT_THRESHOLD) {
            car.setPosition(car.getPosition() + 1);
        }
        car.printStatus();
    }
}
