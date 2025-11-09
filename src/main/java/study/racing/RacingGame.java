package study.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> cars;
    private final Random random;

    public RacingGame(int carCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.random = new Random();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }


}
