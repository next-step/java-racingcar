package racingcar_step4;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame() {
    }

    public List<Car> createCars(String[] names) {
        cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> runRacing() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }
}
