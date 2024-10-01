package racinggame.racingcar;

import java.util.List;

public class Race {
    private final RacingCars racingCars;
    private final MoveStrategy moveStrategy;

    public Race(RacingCars racingCars, MoveStrategy moveStrategy) {
        this.racingCars = racingCars;
        this.moveStrategy = moveStrategy;
    }

    public void createRacingCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            racingCars.addCar(moveStrategy);
        }
    }

    public List<Integer> proceedRounds() {
        racingCars.moveAll();
        return racingCars.getCurrentPositionsRepresentation();
    }
}
