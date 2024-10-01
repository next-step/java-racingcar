package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();
    private List<Car> cars;
    private GameRounds rounds;

    public GameRounds start(int carCount, int tryCount) {
        validateNegative(carCount, tryCount);
        initCar(carCount);
        rounds = new GameRounds();
        for (int i = 0; i < tryCount; i++) {
            playGameRound();
        }
        return rounds;
    }

    private void playGameRound() {
        moveCars();
        saveGameResult();
    }

    private void saveGameResult() {
        GameResults gameResults = new GameResults();
        for (Car car : cars) {
            gameResults.add(car.getPosition());
        }
        rounds.add(gameResults);
    }

    private void moveCars() {
        for (Car car : cars) {
            var number = random.nextInt(DEFAULT_BOUND);
            car.move(number);
        }
    }

    private void initCar(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.create());
        }
    }

    private void validateNegative(int carCount, int tryCount) {
        if (carCount <= 0 || tryCount <= 0) {
            throw new RuntimeException("음수가 전달되어 게임을 시작할 수 없습니다.");
        }
    }
}
