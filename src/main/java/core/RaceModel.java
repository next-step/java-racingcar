package core;

import utils.PowerSupply;

import java.util.List;

public class RaceModel {
    private Cars cars;
    private int moveCount;

    private RaceModel(Cars cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public static RaceModel initialize(List<CarName> carNames, int moveCount) {
        return new RaceModel(Cars.fromCarNames(carNames), moveCount);
    }

    public void moveCarsRandomlyMoveCountTimes(PowerSupply powerSupply) {
        Cars resultCars = cars;
        for (int i = 0; i < moveCount; i++) {
            resultCars = moveCarsRandomly(resultCars, powerSupply);
        }
        cars = resultCars;
    }

    public Cars getCars() {
        return cars;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private static Cars moveCarsRandomly(Cars cars, PowerSupply powerSupply) {
        return cars.moveCarsRandomly(powerSupply);
    }
}
