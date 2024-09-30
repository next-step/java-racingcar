package racinggame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();
    private int round;
    private Map<Car, Integer> racingMap;

    public RacingGame() {
        this.round = 1;
    }

    public int getRound() {
        return round;
    }

    public void start(int carCount, int tryCount) {
        validateNegative(carCount, tryCount);
        initCar(carCount);
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            printCarPosition();
            validateNextRound(tryCount);
        }
    }

    private void printCarPosition() {
        ResultView.printCarPosition(racingMap);
    }

    private void moveCars() {
        for (Car car : racingMap.keySet()) {
            var number = random.nextInt(DEFAULT_BOUND);
            car.move(number);
            racingMap.put(car, car.getPosition());
        }
    }

    private void initCar(int carCount) {
        racingMap = new HashMap<>();
        for (int i = 0; i < carCount; i++) {
            var car = Car.create();
            racingMap.put(car, car.getPosition());
        }
    }

    private void validateNegative(int carCount, int tryCount) {
        if (carCount <= 0 || tryCount <= 0) {
            throw new RuntimeException("음수가 전달되어 게임을 시작할 수 없습니다.");
        }
    }

    private void validateNextRound(int tryCount) {
        if (isNextRound(tryCount)) {
            round++;
            ResultView.printNewLine();
        }
    }

    private boolean isNextRound(int tryCount) {
        return round < tryCount;
    }
}
