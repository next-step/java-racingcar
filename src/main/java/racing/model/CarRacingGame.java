package racing.model;

import racing.utils.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final int MAX_BOUND = 10;

    private final RandomGenerator randomGenerator = new RandomGenerator(MAX_BOUND);
    private final Cars cars;
    private final int numberOfMove;
    private int movingCount = 0;

    public CarRacingGame(List<String> carNames, int numberOfMove) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(cars);
        this.numberOfMove = numberOfMove;
    }

    public List<Car> extractWinners() {
        return cars.findWinners();
    }

    public void moveCars() {
        if (!isPossibleToMove()) {
            throw new IllegalStateException("더 이상 이동할 수 없습니다");
        }
        cars.moveAll(randomGenerator);
        movingCount++;
    }

    public boolean isPossibleToMove() {
        return movingCount < numberOfMove;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
