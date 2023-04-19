package racingCarGame.domain;

import racingCarGame.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<Car> cars;
    public RacingCarGame(InputView inputView) {
        List<Car> cars = new ArrayList<>();
        for (String owner : inputView.getOwners()) {
            cars.add(new Car(owner));
        }
        this.cars = cars;
    }

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<String> findWinner() {
        int maxScore = findMaxScore();
        return cars
                .stream().filter(car -> car.isEqualDistance(maxScore))
                .map(Car::getOwner)
                .collect(Collectors.toList());
    }

    private int findMaxScore() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
