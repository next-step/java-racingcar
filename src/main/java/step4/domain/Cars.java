package step4.domain;

import step4.utils.RandomUtils;
import step4.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MAX_BOUND = 10;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException();
        }
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNum(MAX_BOUND));
        }
    }
}
