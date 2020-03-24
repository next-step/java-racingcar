package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int MAX_RANDOM_BOUND = 10;

    private int tryCount;
    private List<Car> cars = new ArrayList<>();
    private final MovableStrategy movableStrategy;

    public RacingGame(MovableStrategy movableStrategy, int numberOfCars, int tryCount) {
        validateNumberAndCount(numberOfCars, tryCount);
        this.movableStrategy = movableStrategy;
        createCars(numberOfCars);
        this.tryCount = tryCount;
    }

    private void validateNumberAndCount(int numberOfCars, int tryCount) {
        if (numberOfCars <= 0 || tryCount <= 0) {
            throw new IllegalArgumentException("차량 수와 라운드 수는 0 이상이어야 합니다.");
        }
    }

    private void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car(movableStrategy);
            cars.add(car);
        }
    }

    public List<List<Integer>> run() {
        List<List<Integer>> roundPositions = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            roundPositions.add(moveAll());
        }
        return roundPositions;
    }

    private List<Integer> moveAll() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.moveIfPossible(getRandom()));
        }
        return positions;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_BOUND);
    }

}
