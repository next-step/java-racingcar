package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import common.NumberGenerator;
import common.RandomNumberGenerator;

public class Vehicles {

    private List<Vehicle> vehicles;
    private NumberGenerator numberGenerator;

    public Vehicles(List<String> carNames) {
        this.vehicles = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        this.numberGenerator = new RandomNumberGenerator();
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void move() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move(numberGenerator.getNumber());
        }
    }
}
