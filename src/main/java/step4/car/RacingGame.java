package step4.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final int tryCount;
    private final List<Car> entryCars = new ArrayList<>();
    private MovingStrategy movingStrategy;
    private ResultRecorder resultRecorder;

    private RacingGame(int tryCount, MovingStrategy movingStrategy) {
        tryCountCheck(tryCount);
        this.tryCount = tryCount;
        this.movingStrategy = movingStrategy;
    }

    public void registerCars(String[] names) {
        validNamesCheck(names);
        for (String name : names) {
            entryCars.add(Car.of(name));
        }
    }

    public void startGame(){
        registerCarCheck();
        initGame();

        for (int i = 0; i < tryCount; i++) {
            tryMove();
        }
    }

    public static RacingGame of(int tryCount) {
        return new RacingGame(tryCount, null);
    }

    // 테스트용
    public static RacingGame of(int tryCount, MovingStrategy strategy) {
        return new RacingGame(tryCount, strategy);
    }

    public List<Car> getEntryCars() {
        return entryCars;
    }

    public ResultRecorder getResultRecorder() {
        return resultRecorder;
    }

    private void validNamesCheck(String[] names) {
        if (names == null || names.length <= 0) {
            throw new IllegalArgumentException("차량 이름 목록이 null 이거나 비어있습니다.");
        }

        Arrays.stream(names)
                .forEach(name -> {
                    if (name == null || name.replaceAll(" ", "").isEmpty()) {
                        throw new IllegalArgumentException("차량 이름이 유효하지 않습니다. " + name);
                    }
                });
    }

    private void registerCarCheck() {
        if (entryCars.isEmpty()) {
            throw new IllegalStateException("차량이 등록되지 않았습니다.");
        }
    }

    private void initGame() {
        if (movingStrategy == null) {
            movingStrategy = new RandomMovingStrategy();
        }
        resultRecorder = new ResultRecorder();
        entryCars.forEach(Car::initPosition);
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
