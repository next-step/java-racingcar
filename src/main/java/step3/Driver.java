package step3;

import java.util.List;

public class Driver {

    private List<Car> cars;

    public Driver(List<Car> cars) {
        this.cars = cars;
    }

    public void drive(int random) {
        if (isDrive(random)) {
            cars.stream().forEach(Car::move);
        }
    }

    private boolean isDrive(int random) {
        return Checkor.check(random);
    }

}
