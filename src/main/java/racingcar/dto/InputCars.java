package racingcar.dto;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public final class InputCars {
    private final Cars cars;

    private InputCars(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public Cars getCars() {
        return cars;
    }

    public static InputCars fromNonEmptySize(int size) {
        validate(size);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return new InputCars(cars);
    }

    private static void validate(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다. 입력 값 : " + size);
        }
    }
}
