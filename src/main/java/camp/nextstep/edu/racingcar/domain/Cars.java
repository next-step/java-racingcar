package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        assert carList != null;
        this.carList = new ArrayList<>(carList);
    }

    public static Cars defaultInstance(CarNames carNames) {
        AssertUtils.notNull(carNames, "'carNames' must not be null");
        final List<Car> carList = carNames.stream()
                .map(Car::from)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public Stream<Car> stream() {
        return carList.stream();
    }

    public int size() {
        return carList.size();
    }

    public Cars move(MovingStrategy movingStrategy) {
        final List<Car> movedCarList = carList.stream()
                .map(car -> {
                    final int distance = movingStrategy.getDistanceToMove();
                    return car.move(distance);
                })
                .collect(Collectors.toList());
        return new Cars(movedCarList);
    }

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
