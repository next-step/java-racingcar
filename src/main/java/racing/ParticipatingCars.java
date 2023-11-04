package racing;

import racing.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ParticipatingCars {
    private List<Car> participatingCars = new ArrayList<>();

    public void join(Car car) {
        this.participatingCars.add(car);
    }

    public List<Car> cars() {
        return this.participatingCars;
    }
}
