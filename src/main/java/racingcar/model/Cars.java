package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(MovingStrategy movingStrategy, String[] names) {
        for (String name : names) {
            cars.add(new Car(movingStrategy, name));
        }
    }

    public List<Car> getCars() {
        for (Car car : cars) {
            System.out.println("car.getName() = " + car.getName());
        }
        return cars;
    }

    public void runRace() {
        for (Car car : cars) {
            car.move();
        }
    }
}
