package racingcar.domain;

import java.util.List;

import common.NumberGenerator;

public class RacingGame implements Game {
    List<Vehicle> vehicles;
    NumberGenerator numberGenerator;

    public RacingGame(List<Vehicle> vehicles, NumberGenerator numberGenerator) {
        this.vehicles = vehicles;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void start() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move(numberGenerator.getNumber());
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
