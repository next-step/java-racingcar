package racing.domain;

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

    private Cars filterPosition(int position) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(Collectors.toList());
        return new Cars(filteredCars);
    }

    private int getMaxPosition() {
        int max=0;
        return cars.stream()
                .mapToInt(car -> car.max(max))
                .max()
                .orElse(0);
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
