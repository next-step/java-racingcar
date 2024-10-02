package racinggame.racingcar;

import java.util.List;

public class Race {
    private final RacingCars racingCars;

    private Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Race create(int numberOfCars, MoveStrategy moveStrategy) {
        RacingCars racingcars = RacingCars.create(numberOfCars, moveStrategy);
        return new Race(racingcars);
    }

    public List<Integer> proceedRounds() {
        racingCars.moveAll();
        return racingCars.getCurrentPositionsRepresentation();
    }

    public int getNumberOfCars() {
        return racingCars.count();
    }
}
