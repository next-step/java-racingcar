package step3.car;

import step3.random.RandomNumberGenerator;

public class CarController {
    public static final int ALLOWED_MINIMUM_DISTANCE = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveCar(Car car) {
        int randomDistance = randomNumberGenerator.generate();
        if (canMove(randomDistance)) {
            car.move(randomDistance);
        }
    }

    private boolean canMove(int distance) {
        return distance >= ALLOWED_MINIMUM_DISTANCE;
    }
}
