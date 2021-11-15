package racingcar.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.strategy.MoveStrategy;

public class Cars {

    private static final String DELIMITER = ",";

    private List<Car> cars;
    private int tryCountTotal = 0;

    private Cars(String[] names) {
        this.cars = Arrays.stream(names)
            .map(Car::from)
            .collect(Collectors
                .toCollection(ArrayList::new));
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String name) {
        String[] names = name.split(DELIMITER);
        return new Cars(names);
    }

    public long size() {
        return cars.size();
    }

    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        tryCountTotal++;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getTryCountTotal() {
        return tryCountTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return tryCountTotal == cars1.tryCountTotal && Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryCountTotal);
    }
}
