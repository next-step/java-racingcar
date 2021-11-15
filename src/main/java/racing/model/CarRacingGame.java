package racing.model;

import racing.utils.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final int MAX_BOUND = 10;

    private final RandomGenerator randomGenerator = new RandomGenerator(MAX_BOUND);
    private final List<Car> cars;
    private final int numberOfMove;
    private int movingCount = 0;

    public CarRacingGame(List<String> carNames, int numberOfMove) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.numberOfMove = numberOfMove;
    }

    public List<Car> extractWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .filter(car -> car.isEqualMovingDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getMovingDistance)
                .max()
                .orElseThrow(() -> new NoSuchElementException("cars 중 maxDistance 를 찾는데 실패하였습니다."));
    }

    public void moveCars() {
        if (!isPossibleToMove()) {
            throw new IllegalStateException("더 이상 이동할 수 없습니다");
        }
        for (Car car : cars) {
            int randomValue = randomGenerator.nextInt();
            car.move(randomValue);
        }
        movingCount++;
    }

    public boolean isPossibleToMove() {
        return movingCount < numberOfMove;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
