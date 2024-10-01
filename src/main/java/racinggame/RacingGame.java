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

    public List<List<Integer>> start(int carCount, int tryCount) {
        validateNegative(carCount, tryCount);
        initCar(carCount);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            moveCars();

            List<Integer> positions = new ArrayList<>();
            for (Car car : cars) {
                positions.add(car.getPosition());
            }
            results.add(positions);
            validateNextRound(tryCount);
        }
        return results;
    }

    private void moveCars() {
        for (Car car : cars) {
            int number = random.nextInt(DEFAULT_BOUND);
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
        }
    }

    private boolean isNextRound(int tryCount) {
        return round < tryCount;
    }
}
