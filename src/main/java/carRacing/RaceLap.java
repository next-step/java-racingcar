package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RaceLap {

    private List<Car> cars;

    public RaceLap(Engine engine, int numberOfCars) {
        cars = new ArrayList<>();
        raceSetting(engine, numberOfCars);
    }

    public List<Car> getCars() {
        return cars;
    }
    public RaceLap race() {
        for (Car car : cars) {
            car.move();
        }
        return this;
    }

    private void raceSetting(Engine engine, int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(engine));
        }
    }

}
