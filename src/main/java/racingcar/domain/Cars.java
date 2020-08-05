package racingcar.domain;

import racingcar.constant.RacingMessage;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int MIN_CAR_SIZE = 1;
    private List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public Cars(int count) {
        readyCars(count);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public int getSize() {
        return this.carList.size();
    }

    public void readyCars(int count) {
        validate(count);
        this.carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            this.carList.add(new Car());
        }
    }

    public void moveAll() {
        for (Car car : this.carList) {
            car.move(RandomGenerator.getNumber());
        }
    }

    private void validate(int count) {
        if (count < MIN_CAR_SIZE) {
            throw new IllegalArgumentException(RacingMessage.VALIDATE_MINIMUM_CAR);
        }
    }
}
