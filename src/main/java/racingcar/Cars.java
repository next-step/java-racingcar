package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars extends ArrayList<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars() {
        this.cars = new ArrayList<Car>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public Car remove(int index) {
        throw new IllegalCallerException("remove does not allowed.");
    }

}
