package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {

    private final List<Car> cars;
    private final int gameCount;

    public RaceGame(int carCount, int gameCount) {
        validateCarCount(carCount);
        validateGameCount(gameCount);
        this.cars = createCars(carCount);
        this.gameCount = gameCount;
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

    public void playRound() {
        Random random = new Random();
        for (Car car : cars) {
            car.moveIfPossible(random.nextInt(10));
        }
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void validateCarCount(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 합니다.");
        }
    }

    private void validateGameCount(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException("게임 횟수는 1회 이상이어야 합니다.");
        }
    }
}