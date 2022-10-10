package racingcar.domain;

import racingcar.dto.CarsRecord;
import racingcar.strategy.MovingStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = values;
    }

    public CarsRecord move(MovingStrategy movingStrategy) {
        CarsRecord records = new CarsRecord();
        for (Car car : values) {
            car.moves(movingStrategy);
            records.add(car);
        }
        return records;
    }

    public CarsRecord findWinners() {
        CarsRecord records = new CarsRecord();
        List<Car> winners = getWinners(getMaxPosition());
        for (Car winner : winners) {
            records.add(winner);
        }
        return records;
    }

    private List<Car> getWinners(CarPosition maxPosition) {
        return values.stream()
                .filter(value -> value.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private CarPosition getMaxPosition() {
        CarPosition maxPosition = new CarPosition();
        for (Car car : values) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
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
