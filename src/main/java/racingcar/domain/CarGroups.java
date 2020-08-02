package racingcar.domain;

import racingcar.constant.RacingMessage;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarGroups {
    private static final int MIN_CAR_SIZE = 1;
    private List<Car> cars;

    public CarGroups(int count) {
        readyCars(count);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void readyCars(int count) {
        validate(count);
        this.cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.move(RandomGenerator.getNumber());
        }
    }

    private void validate(int count) {
        if (count < MIN_CAR_SIZE) {
            throw new IllegalArgumentException(RacingMessage.VALIDATE_MINIMUM_CAR);
        }
    }
}
