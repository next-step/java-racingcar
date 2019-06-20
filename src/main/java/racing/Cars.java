package racing;

import racing.strategy.DrivingRandomStrategy;
import racing.strategy.DrivingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> names) {
        cars = new ArrayList<>(names.size());

        for (String carName : names) {
            cars.add(new Car(carName));
        }
    }

    public void go(DrivingStrategy strategy) {
        for (Car car : cars) {
            car.goOrNot(strategy);
        }
    }

    public int findMaxPosition() {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            int position = car.getPosition();
            if (isBigger(position, max)) {
                max = position;
            }
        }

        return max;
    }

    public List<Car> findCarsInPosition(int pos) {
        List<Car> founds = cars.stream()
                .filter(car -> car.getPosition() == pos)
                .collect(Collectors.toList());

        return founds;
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

    private boolean isBigger(int original, int target) {
        return original > target;
    }
}
