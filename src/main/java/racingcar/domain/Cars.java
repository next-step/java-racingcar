package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import racingcar.domain.moving.MovingStrategy;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(CarNames names) {
        List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
    
    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy.go());
        }
    }

    public Cars longest() {
        Car max = Collections.max(cars);
        List<Car> longest = new ArrayList<>();
        for (Car car : cars) {
            addEqualsDistance(max, longest, car);
        }
        return new Cars(longest);
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.name());
        }
        return names;
    }

    private void addEqualsDistance(Car max, List<Car> longest, Car car) {
        if (max.distance() == car.distance()) {
            longest.add(car);
        }
    }
    
    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Cars other = (Cars) o;
        return cars.containsAll(other.cars) && other.cars.containsAll(cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
