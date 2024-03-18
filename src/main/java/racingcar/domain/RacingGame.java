package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String getWinners() {
        int maxMovePosition = vehicles.getMaxPositionVehicle();
        return vehicles.getMatchVehicle(maxMovePosition);
    }
}
