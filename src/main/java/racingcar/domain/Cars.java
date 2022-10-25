package racingcar.domain;

import racingcar.strategy.Generator;
import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars of(Car... cars) {
        return new Cars(List.of(cars));
    }

    public void move(Generator generator) {
        for (Car car : cars) {
            car.move(generator);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Cars create(String names) {
        validateIsNullOrEmpty(names);
        List<Car> cars = new ArrayList<>();
        for (String name : StringUtil.splitNames(names)) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    private static void validateIsNullOrEmpty(String names) {
        if (names == null || names.length() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    public List<Name> findWinners() {
        return findSameLocationCars(findMaxLocationCar());
    }

    private Car findMaxLocationCar() {
        Car max = cars.get(0);
        for (Car car : cars) {
            max = far(max, car);
        }
        return max;
    }

    private Car far(Car max, Car target) {
        if (target.isFar(max)) {
            return target;
        }
        return max;
    }

    private List<Name> findSameLocationCars(Car max) {
        return cars.stream()
                .map(car -> car.findCollinearName(max))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
