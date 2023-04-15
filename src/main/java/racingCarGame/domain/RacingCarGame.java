package racingCarGame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<Car> cars;
    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }
    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> findWinner() {
        int maxScore = findMaxScore();
        return cars
                .stream().filter(
                        car -> car.getDistance() == maxScore
                )
                .map(Car::getOwner)
                .collect(Collectors.toList());
    }

    private int findMaxScore() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
}
