package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();
    private int round;
    private List<Car> cars;

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
        ResultView.printCarPosition(cars);
    }

    private void moveCars() {
        for (Car car : cars) {
            var number = random.nextInt(DEFAULT_BOUND);
            car.move(number);
        }
    }

    private void initCar(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.create());
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
