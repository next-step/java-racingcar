package racingcar.car;

import racingcar.random.RandomNumberGenerator;

public class CarController {

    private final RandomNumberGenerator randomNumberGenerator;

    public CarController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveCar(Car car) {
        int randomDistance = randomNumberGenerator.generate();
        car.move(randomDistance);
    }

}
