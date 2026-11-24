package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int remainingTryCount;
    private final Cars cars;
    private final NumberGenerator generator;
    private final List<RoundResult> history = new ArrayList<>();

    public RacingGame(Cars cars, int tryCount, NumberGenerator generator) {
        validateTryCount(tryCount);
        this.remainingTryCount = tryCount;
        this.cars = cars;
        this.generator = generator;
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
        cars.move(generator);
        remainingTryCount--;
    }

    private void recordRound() {
        history.add(new RoundResult(getPositions()));
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new RuntimeException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public List<Integer> getPositions() {
        return cars.getPositions();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

}
