package carrace.vehicle;

import carrace.rules.CarRaceRules;

public class Vehicles {

    private final Vehicle[] vehicles;

    public Vehicles(Vehicle[] vehicles) {
        if (vehicles == null || vehicles.length <= 1) {
            throw new RuntimeException("자동차 대수는 2 이상의 값이어야합니다.");
        }
        this.vehicles = vehicles;
    }

    public void moveAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move(CarRaceRules.generateRandomValue());
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }
}
