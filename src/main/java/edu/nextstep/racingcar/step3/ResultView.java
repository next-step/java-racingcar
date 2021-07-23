package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.step3.app.Vehicle;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final String DISPLAY_TOKEN = "-";
    private final List<Vehicle> vehicles;
    private final Integer numberOfAttempts;

    public ResultView(List<Vehicle> vehicles, int numberOfAttempts) {
        this.vehicles = vehicles;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void play() {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt());
    }

    private void attempt() {
        vehicles.forEach(vehicle -> {
            calculateDistance(vehicle);
            printDistance(vehicle);
        });

        System.out.print("\n");
    }

    private void printDistance(Vehicle vehicle) {
        IntStream.range(0, vehicle.getDistance()).forEach(distanceIdx -> System.out.print(DISPLAY_TOKEN));
        System.out.print("\n");
    }

    private void calculateDistance(Vehicle vehicle) {
        if (vehicle.isMove()) {
            vehicle.setDistance(vehicle.getDistance() + 1);
        }
    }
}
