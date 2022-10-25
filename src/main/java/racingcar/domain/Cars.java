package racingcar.domain;

import racingcar.generator.Generator;
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

    public Location findMaxLocation() {
        Location max = new Location();
        for (Car car : cars) {
            max = car.findFar(max);
        }
        return max;
    }

    public List<Name> findSameLocationCarNames(Location max) {
        return cars.stream()
                .map(car -> car.findCollinearName(max))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
