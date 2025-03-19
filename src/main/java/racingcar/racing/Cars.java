package racingcar.racing;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        cars.add(car);
    }

    public void moveAll() {
        cars.forEach(Car::play);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> {
            result.append(car.getName()).append(" : ");
            result.append("-".repeat(Math.max(0, car.getDistance())));
            result.append("\n");
        });
        return result.toString();
    }
}
