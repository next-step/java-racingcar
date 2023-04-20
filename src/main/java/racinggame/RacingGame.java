package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void readyCar(String[] carsName) {
        for (String name : carsName) {
            cars.add(new Car(name));
        }
    }

    public void playGame() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
