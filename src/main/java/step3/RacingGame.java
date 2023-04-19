package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void readyCar(int CarCount) {
        for (int i = 0; i < CarCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> playGame() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
        }
        return cars;
    }

}
