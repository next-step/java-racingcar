package step3;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(RandomGenerator generator) {
        cars.stream()
                .forEach(car -> car.move(generator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
