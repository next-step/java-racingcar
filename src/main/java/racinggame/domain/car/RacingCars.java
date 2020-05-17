package racinggame.domain.car;

import racinggame.domain.strategy.MovableStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<RacingCar> racingCars;

    private RacingCars(String[] carNames, MovableStrategy movableStrategy) {
        this.racingCars = Arrays.stream(carNames)
                .map(carName -> RacingCar.newInstance(carName, movableStrategy))
                .collect(Collectors.toList());
    }

    public static RacingCars newInstance(String[] carNames, MovableStrategy movableStrategy) {
        return new RacingCars(carNames, movableStrategy);
    }

    public void moveAll() {
        this.racingCars.forEach(RacingCar::move);
    }

    public void changeMovableStrategy(MovableStrategy movableStrategy) {
        this.racingCars.forEach(racingCar -> racingCar.setMovableStrategy(movableStrategy));
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public String getWinnerCarNames() {
        int maxPosition = getWinnerPosition();

        return this.racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.joining(","));
    }

    private int getWinnerPosition() {
        return this.racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .get()
                .getPosition();
    }
}
