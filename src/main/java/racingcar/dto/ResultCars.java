package racingcar.dto;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.model.Distance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultCars {
    private final Cars cars;

    private ResultCars(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public Cars value() {
        return cars;
    }

    public static ResultCars of(int count, List<CarName> names, List<Distance> distances) {
        validate(count, names, distances);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car(names.get(i), distances.get(i)));
        }
        return new ResultCars(cars);
    }

    private static void validate(int count, List<CarName> names, List<Distance> distances) {
        Objects.requireNonNull(names, "ResultCars 에 전달된 입력 값이 올바르지 않습니다 : names is null");
        Objects.requireNonNull(distances, "ResultCars 에 전달된 입력 값이 올바르지 않습니다 : distances is null");

        if (count != names.size() && count != distances.size()) {
            throw new IllegalArgumentException(
                    String.format("ResultCars에 전달된 리스트의 사이즈가 같지 않습니다. count(%d) names(%d) distances(%d)"
                            , count, names.size(), distances.size()));
        }
    }
}
