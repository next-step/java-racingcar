package racing;

import racing.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private ParticipatingCars participatingCars;

    public Racing() {
        this.participatingCars = new ParticipatingCars();
    }

    public List<Car> ready(int numberOfCar) {
        for (int i = 0; i < numberOfCar; ++i) {
            participatingCars.join(new Car("test"));
        }
        return this.participatingCars();
    }

    public List<Car> participatingCars() {
        return participatingCars.cars();
    }
}
