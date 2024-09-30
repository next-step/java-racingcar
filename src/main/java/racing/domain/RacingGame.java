package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int roundCount;

    private final List<Car> cars;

    private RacingGame(int roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        this.cars = cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<GameResult> start() {
        List<GameResult> results = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            playRound(results);
        }
        return results;
    }

    private void playRound(List<GameResult> results) {
        moveCars();
        List<Integer> positions = getCurrentPositions();
        saveRoundResult(results, positions);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<Integer> getCurrentPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getCurrentPosition());
        }
        return positions;
    }

    private void saveRoundResult(List<GameResult> results, List<Integer> positions) {
        results.add(GameResult.save(positions));
    }

    public static RacingGame setUp(int roundCount, List<Car> cars) {
        return new RacingGame(roundCount, cars);
    }
}
