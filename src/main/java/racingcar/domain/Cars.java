package racingcar.domain;

import racingcar.dto.CarsRecord;
import racingcar.strategy.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    public static final String COMMA = ",";

    private final List<Car> values;

    public Cars(String carNames) {
        this.values = create(carNames);
    }

    public Cars(List<Car> values) {
        this.values = values;
    }

    private List<Car> create(String carNames) {
        List<String> carNameValues = Arrays.asList(carNames.split(COMMA));
        return carNameValues.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return values.size();
    }

    public CarsRecord move(MovingStrategy movingStrategy) {
        CarsRecord records = new CarsRecord();
        for (Car value : values) {
            value.moves(movingStrategy);
            records.add(value);
        }
        return records;
    }

    public List<Car> findWinners() {
        return getWinners(getMaxPosition());
    }

    private List<Car> getWinners(CarPosition maxPosition) {
        return values.stream().filter(value -> value.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private CarPosition getMaxPosition() {
        CarPosition maxPosition = new CarPosition();
        for (Car value : values) {
            maxPosition = value.getMaxPosition(maxPosition);
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
