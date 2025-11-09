package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {

    private final List<Car> cars;
    private final int gameCount;

    public RaceGame(int carCount, int gameCount) {
        this.cars = createCars(carCount);
        this.gameCount = gameCount;
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> cars() {
        return cars;
    }

    public int gameCount() {
        return gameCount;
    }

    public void playGame() {
        for (int i = 0; i < gameCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        Random random = new Random();
        for (Car car : cars) {
            car.moveIfPossible(random.nextInt(10));
        }
    }
}
