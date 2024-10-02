package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();
    private List<Car> cars;
    private GameRounds rounds;

    public GameRounds start(List<String> carNames, int tryCount) {
        validateNegative(tryCount);
        initCar(carNames);
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
        gameResults.save(cars);
        rounds.add(gameResults);
    }

    private void moveCars() {
        for (Car car : cars) {
            var number = random.nextInt(DEFAULT_BOUND);
            car.move(number);
        }
    }

    private void initCar(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.create(carName));
        }
    }

    private void validateNegative(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("음수가 전달되어 게임을 시작할 수 없습니다.");
        }
    }
}
