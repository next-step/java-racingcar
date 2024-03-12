package racingcar;

import java.util.ArrayList;
import java.util.List;

import common.RandomUtil;

public class RacingGame implements Game {
    List<Vehicle> vehicles = new ArrayList<>();

    public RacingGame(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void start() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move(RandomUtil.getRandomNumber());
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
