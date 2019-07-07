package racing.domain;

import racing.domain.strategy.DrivingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(name -> Car.of(name))
                .collect(Collectors.toList());
    }

    public void go(DrivingStrategy strategy) {
        cars.stream()
                .forEach(car -> car.goOrNot(strategy));
    }

    public int findMaxPosition() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            max = car.max(max);
        }

        return max;
    }

    public List<Car> findCarsInPosition(int pos) {
        return cars.stream()
                .filter(car -> car.getPosition() == pos)
                .collect(Collectors.toList());
    }

    public int size() {
        return cars.size();
    }

    public Car getCar(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return cars.get(index);
    }

    public List<Car> toList() {
        return cars;
    }
}
