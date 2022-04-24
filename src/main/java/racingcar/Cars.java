package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;
    private int index;

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

    public List<String> collectWinner(int max, List<String> winners, Cars cars) {
        for (Car car : cars) {
            if (car.isWinner(max)) {
                winners.add(car.name);
            }
        }
        return winners;
    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public Car get(int i) {
        return this.cars.get(i);
    }
}
