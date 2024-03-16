package racingcar.domain;

import java.util.List;

import common.NumberGenerator;

public class RacingGame implements Game {

    private Vehicles vehicles;

    public RacingGame(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void start() {
        vehicles.move();
    }
}
