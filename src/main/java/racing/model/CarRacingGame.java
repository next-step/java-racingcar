package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars = new ArrayList<>();
    private final int numberOfMove;
    private int movingCount = 0;

    public CarRacingGame(List<String> carNames, int numberOfMove) {
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.numberOfMove = numberOfMove;
    }

    public List<Car> extractWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .filter(car -> car.getMovingDistance() == maxDistance)
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
        cars.forEach(Car::moveRandom);
        movingCount++;
    }

    public boolean isPossibleToMove() {
        return movingCount < numberOfMove;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
