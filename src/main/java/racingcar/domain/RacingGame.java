package racingcar.domain;

import java.util.List;

public class RacingGame implements Game {

    private Vehicles vehicles;

    public RacingGame(List<String> carNames) {

        this.vehicles = new Vehicles(carNames);
    }

    @Override
    public void start() {
        vehicles.move();
    }

    @Override
    public Vehicles getVehicles() {
        return vehicles;
    }
}
