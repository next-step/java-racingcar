package racingcar.domain;

import racingcar.dto.CarsRecord;
import racingcar.strategy.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String SEPARATOR = ",";
    private static final String CAR_NAME_NULL_MESSAGE = "자동차의 이름의 값이 없습니다.";

    private final List<Car> values;

    public Cars(String carNames) {
        this.values = create(carNames);
    }

    public Cars(List<Car> values) {
        this.values = values;
    }

    private List<Car> create(String carNames) {
        List<String> carNameValues = Arrays.asList(carNames.split(SEPARATOR));
        if (carNameValues.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_NULL_MESSAGE);
        }
        return carNameValues.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return values.size();
    }

    public CarsRecord move(MovingStrategy movingStrategy) {
        CarsRecord records = new CarsRecord();
        for (Car car : values) {
            car.moves(movingStrategy);
            records.add(car);
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
