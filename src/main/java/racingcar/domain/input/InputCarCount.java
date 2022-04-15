package racingcar.domain.input;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class InputCarCount {

    private CarCount carCount;

    public InputCarCount(String value) {
        this.carCount = new CarCount(value);
    }

    public List<Car> toCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount.getCount(); i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
