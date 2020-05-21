package step4.car;

import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> entryCars;
    private final MovingStrategy movingStrategy;
    private final ResultRecorder resultRecorder;

    private RacingGame(int tryCount, MovingStrategy movingStrategy, List<Car> entryCars) {
        tryCountCheck(tryCount);
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
        this.entryCars = entryCars;
        this.resultRecorder = new ResultRecorder();
    }

    public void startGame() {
        registerCarCheck();

        for (int i = 0; i < tryCount; i++) {
            tryMove();
        }
    }

    public static RacingGame of(int tryCount, List<Car> cars) {
        return new RacingGame(tryCount, new RandomMovingStrategy(), cars);
    }

    // 테스트용
    public static RacingGame of(int tryCount, MovingStrategy strategy, List<Car> cars) {
        return new RacingGame(tryCount, strategy, cars);
    }

    public List<Car> getEntryCars() {
        return entryCars;
    }

    public ResultRecorder getResultRecorder() {
        return resultRecorder;
    }

    private void registerCarCheck() {
        if (entryCars == null || entryCars.isEmpty()) {
            throw new IllegalStateException("차량이 등록되지 않았습니다.");
        }
    }

    private void tryMove() {
        for (Car car : entryCars) {
            car.move(movingStrategy);
        }
        resultRecorder.recordCurrentPosition(entryCars);
    }

    private void tryCountCheck(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 회수는 0 보다 커야 합니다.");
        }
    }
}
