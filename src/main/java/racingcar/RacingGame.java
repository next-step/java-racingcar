package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }
    public void tryGame() {
        Random random = new Random();

        for (Car car : cars) {
            if (random.nextInt(10) >= 4) {
                car.forward();
            }
        }
    }
}
