package edu.nextstep.racingcar.step3.view;

import edu.nextstep.racingcar.step3.app.Vehicle;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String DISPLAY_TOKEN = "-";
    private static final String NEW_LINE = "\n";

    public void play(int numberOfAttempts, List<Vehicle> vehicles) {
        IntStream.range(0, numberOfAttempts).forEach(idx -> attempt(vehicles));
    }

    private void attempt(List<Vehicle> vehicles) {
        vehicles.forEach(vehicle -> {
            calculateDistance(vehicle);
            printDistance(vehicle);
        });

        System.out.print(NEW_LINE);
    }

    private void printDistance(Vehicle vehicle) {
        IntStream.range(0, vehicle.getDistance()).forEach(distanceIdx -> System.out.print(DISPLAY_TOKEN));
        System.out.print(NEW_LINE);
    }

    private void calculateDistance(Vehicle vehicle) {
        if (vehicle.isMove()) {
            vehicle.setDistance(vehicle.getDistance() + 1);
        }
    }
}
