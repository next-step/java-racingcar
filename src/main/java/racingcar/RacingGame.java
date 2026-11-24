package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator generator;
    private final List<RoundResult> history = new ArrayList<>();
    private boolean finished;

    public RacingGame(int carCount, int tryCount, NumberGenerator generator) {
        validateCarCount(carCount);
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.generator = generator;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race() {
        if (finished) {
            throw new RuntimeException("이미 완료된 게임입니다.");
        }
        for (int i = 0; i < tryCount; i++) {
            playRound();
            recordRound();
        }
        finished = true;
    }

    public List<RoundResult> getRaceResult() {
        return new ArrayList<>(history);
    }

    private void playRound() {
        for (Car car : cars) {
            car.tryMove(generator.create());
        }
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
        if (tryCount < 0) {
            throw new RuntimeException("시도 횟수는 0 이상이어야 합니다.");
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
