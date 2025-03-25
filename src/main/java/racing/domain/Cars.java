package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isSize(int size) {
        return cars.size() == size;
    }

    public Cars winners() {
        return this.filterPosition(this.getMaxPosition());
    }

    private Cars filterPosition(Position position) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(Collectors.toList());
        return new Cars(filteredCars);
    }

    private Position getMaxPosition() {
        Comparator<Car> comparator = Comparator.comparingInt(c -> c.getPosition().getValue());
        return cars.stream()
                .max(comparator)
                .map(Car::getPosition)
                .orElse(new Position(0));
    }

    public List<Car> getCarList() {
        return this.cars;
    }

    public void move() {
        for(Car car: cars) {
            car.move();
        }
    }
}
