package step4.domain.racing;

import step4.domain.car.Car;
import step4.domain.ipnut.InputNames;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(InputNames inputNames) {
        this(inputNames.inputNames().stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        if(isNull(cars)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.cars = cars;
    }

    private final boolean isNull(List<Car> cars) {
        return cars == null;
    }

}
