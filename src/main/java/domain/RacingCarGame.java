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

    public RacingCarList playAndReturnCars(MoveStrategy moveStrategy) {
        moveCars(moveStrategy);
        return this.getRacingCarList();
    }

    public void moveCars(MoveStrategy moveStrategy) {
        this.cars.moveCars(moveStrategy);
    }

    public List<RacingCar> getWinners() {
        return this.cars.getWinners();
    }
}
