package racinggame.domain;

import racinggame.domain.collection.Cars;
import racinggame.domain.collection.GameResults;
import racinggame.domain.collection.GameRounds;
import racinggame.domain.strategy.RandomMoveStrategy;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final GameRounds rounds;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
        this.rounds = new GameRounds();
    }

    public GameRounds start(int tryCount) {
        validateNegative(tryCount);
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
        rounds.save(gameResults);
    }

    private void updateWinners(GameResults gameResults, Cars cars) {
        int maxPosition = cars.getMaxPosition();
        cars.getCarList().stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .forEach(gameResults::saveWinners);
    }

    private void moveCars() {
        for (Car car : cars.getCarList()) {
            car.move(new RandomMoveStrategy());
        }
    }

    private void validateNegative(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("음수가 전달되어 게임을 시작할 수 없습니다.");
        }
    }
}
