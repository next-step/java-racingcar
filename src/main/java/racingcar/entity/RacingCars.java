package racingcar.entity;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<Name> carNames) {
        this.racingCars = new ArrayList<>();
        initialize(carNames);
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

    public List<Name> pickWinners(int winnerRecord) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.isSamePositionAs(winnerRecord))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private void initialize(List<Name> carNames) {
        for (Name carName: carNames) {
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
        return Collections.unmodifiableList(racingCars);
    }
}
