package core;

import utils.AnnouncementPrinter;
import utils.CustomScanner;
import utils.NumberGenerator;

import java.util.List;

public class RaceModel {
    private Cars cars;
    private int moveCount;

    public void moveCarsRandomlyMoveCountTimes(NumberGenerator numberGenerator) {
        Cars resultCars = cars;
        for (int i = 0; i < moveCount; i++) {
            resultCars = moveCarsRandomly(resultCars, numberGenerator);
        }
        cars = resultCars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private static Cars moveCarsRandomly(Cars cars, NumberGenerator numberGenerator) {
        return cars.moveCarsRandomly(numberGenerator);
    }

    private static Cars createCarsFromInput() {
        List<CarName> carNames = CustomScanner.scanValidCarNames();
        return Cars.fromCarNames(carNames);
    }
}
