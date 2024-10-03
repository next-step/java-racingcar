package racinggame.domain;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();
    private final Cars cars;
    private final GameRounds rounds;

    public RacingGame() {
        this.cars = new Cars();
        this.rounds = new GameRounds();
    }

    public GameRounds start(List<String> carNames, int tryCount) {
        validateNegative(tryCount);
        initCar(carNames);
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
        GameResults gameResults = new GameResults(cars);
        updateWinners(gameResults, cars);
        rounds.add(gameResults);
    }

    private void updateWinners(GameResults gameResults, Cars cars) {
        int maxPosition = cars.getMaxPosition();
        for (Car car : cars.getCarList()) {
            if (car.isEqualPosition(maxPosition)) {
                gameResults.saveWinners(car);
            }
        }
    }

    private void moveCars() {
        for (Car car : cars.getCarList()) {
            var number = random.nextInt(DEFAULT_BOUND);
            car.move(number);
        }
    }

    private void initCar(List<String> carNames) {
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
