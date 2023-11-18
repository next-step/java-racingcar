package carracing.domain.car;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkCarsSizeIsValid(cars);
        this.cars = cars;
    }

    private void checkCarsSizeIsValid(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars inputCars = (Cars) o;
        return Objects.equals(cars, inputCars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }
}
