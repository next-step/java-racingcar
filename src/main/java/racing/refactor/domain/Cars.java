package racing.refactor.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class Cars {

    private static final int ZERO = 0;

    private final List<Car> values;

    public Cars(List<Car> cars) {
        this.values= cars;
    }

    public Cars getWinners() {
        Position topPosition = topPosition();
        List<Car> winners = values.stream()
                .filter(car -> car.equalsPosition(topPosition))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        return new Cars(winners);
    }

    protected Position topPosition() {
        Car tempCar = values.get(ZERO);
        Position topPosition = tempCar.getPosition();
        for (Car car : values) {
            Position currentPosition = car.getPosition();
            if(topPosition.higherThan(currentPosition)) {
                topPosition = currentPosition;
            }
        }
        return topPosition;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : values) {
            car.move(movingStrategy);
        }
    }

    public List<Car> toList() {
        return this.values;
    }

    public static List<Car> newInstance(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Cars)) return false;
        Cars cars=(Cars) o;
        return Objects.equals(values, cars.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
