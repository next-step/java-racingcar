package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(Collections.unmodifiableList(cars));
    }

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    public Cars forward(final Moveable moveable) {
        return of(cars.stream()
                .map(car -> car.forward(moveable))
                .collect(Collectors.toList()));
    }

    public RoundReport report() {
        return new RoundReport(cars.stream()
                .map(Car::report)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        final Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
