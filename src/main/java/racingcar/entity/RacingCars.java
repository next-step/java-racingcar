package racingcar.entity;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public void moveIfMovableAll(MoveStrategy moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveIfMovable(moveStrategy);
        }
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = racingCar.ifBiggerThanReturnPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> pickWinners(int winnerRecord) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerRecord)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    public void initialize(String[] carNames) {
        for (String carName: carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public int size() {
        return racingCars.size();
    }

    public RacingCar get(int i) {
        return racingCars.get(i);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
