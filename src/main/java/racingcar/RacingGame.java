package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int remainingTryCount;
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator generator;
    private final List<RoundResult> history = new ArrayList<>();

    public RacingGame(int carCount, int tryCount, NumberGenerator generator) {
        validateCarCount(carCount);
        validateTryCount(tryCount);
        this.remainingTryCount = tryCount;
        this.generator = generator;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car("A"));
        }
    }

    public void race() {
        if (isFinished()) {
            throw new RuntimeException("이미 완료된 게임입니다.");
        }
        while (!isFinished()) {
            playRound();
            recordRound();
        }
    }

    public List<RoundResult> getRaceResult() {
        return new ArrayList<>(history);
    }

    private boolean isFinished() {
        return remainingTryCount == 0;
    }

    private void playRound() {
        for (Car car : cars) {
            car.tryMove(generator.create());
        }
        remainingTryCount--;
    }

    private void recordRound() {
        history.add(new RoundResult(getPositions()));
    }

    private static void validateCarCount(int carCount) {
        if (carCount < 1) {
            throw new RuntimeException("자동차 대수는 1 이상이어야 합니다.");
        }
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new RuntimeException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getCarCount() {
        return cars.size();
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

}
