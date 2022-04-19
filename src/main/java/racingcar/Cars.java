package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> createCars(int carCount) {
        validatePositiveNumber(carCount);

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }
        return cars;
    }

    private static void validatePositiveNumber(int carCount) {
        if(carCount < 0) {
            throw new IllegalArgumentException("자동차의 개수는 음수가 될 수 없습니다.");
        }
    }
}
