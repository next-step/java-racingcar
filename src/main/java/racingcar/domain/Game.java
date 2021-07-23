package racingcar.domain;

import racingcar.domain.vehicle.Cars;
import racingcar.domain.vehicle.CarsFactory;

public class Game {

    private final int driveCount;

    private final Cars cars;

    public Game(String carNameString, int driveCount) {
        this.cars = CarsFactory.create(carNameString);
        this.driveCount = driveCount;
    }

    public void playingDrive() {
        cars.doDrive();
    }

    public int getDriveCount() {
        return driveCount;
    }

    public Cars getCars() {
        return cars;
    }
}
