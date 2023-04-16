package domain;

import java.util.List;

public class RacingCarGame {
    private final RacingCarList cars;

    public RacingCarGame(RacingCarList cars) {
        this.cars = cars;
    }

    public RacingCarList getRacingCarList() {
        return this.cars;
    }

    public RacingCarList playAndReturnCars() {
        moveCars();
        return this.getRacingCarList();
    }

    public void moveCars() {
        this.cars.moveCars();
    }

    public List<RacingCar> getWinners() {
        return this.cars.getWinners();
    }
}
