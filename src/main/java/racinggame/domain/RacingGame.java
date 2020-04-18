package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> allCars;
    private int rounds;
    private List<Car> moveResult = new ArrayList<>();

    public RacingGame(List<String> carNames, int rounds) {
        this.allCars = new ArrayList<>(carNames.size());
        this.rounds = rounds;
        for (String carName : carNames) {
            Car racingCar = new Car(carName);
            allCars.add(racingCar);
        }
    }

    public List<Car> allRounds(MoveStrategy moveStrategy) {
        for (int round = 0; round < rounds; round++) {
            this.racing(moveStrategy);
        }
        return moveResult;
    }

    private void racing(MoveStrategy moveStrategy) {
        for (Car car : allCars) {
            car.moveCar(moveStrategy);
            moveResult.add(car.clone());
        }
    }

    public List<Car> findWinners() {
        List<Car> racingResults = this.allCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
        return new Winner(racingResults).findWinnerNames();
    }
}
