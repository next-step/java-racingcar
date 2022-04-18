package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {
        throw new IllegalStateException();
    }

    public static List<Car> createCars(int carCount) {
        if(carCount < 0) {
            throw new IllegalArgumentException("자동차의 개수는 음수가 될 수 없습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car());
        }
        return cars;
    }
}
