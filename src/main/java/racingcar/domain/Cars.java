package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> values;

    public Cars(int carCount) {
        this.values = createCarList(carCount);
    }

    public Cars(List<Car> values) {
        this.values = values;
    }

    private List<Car> createCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public List<Car> racing(int tryCount, MovingStrategy movingStrategy) {
        for (int i = 0; i < tryCount; i++) {
            values.forEach(car -> car.move(movingStrategy));
        }
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(values, cars.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
