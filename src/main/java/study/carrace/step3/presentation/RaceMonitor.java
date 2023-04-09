package study.carrace.step3.presentation;

import study.carrace.step3.domain.Car;

import java.util.List;

public class RaceMonitor {
    private final char POSITION_CURSOR = '-';
    private final List<Car> cars;

    public RaceMonitor(List<Car> cars) {
        this.cars = cars;
    }

    public void showCarsPosition() {
        cars.forEach(car -> showPositionOf(car));
    }

    private void showPositionOf(Car car) {
        System.out.println("🚙" + positionOf(car));
    }

    private String positionOf(Car car) {
        StringBuilder carPosition = new StringBuilder();
        car.getMoveStatus().stream()
                .filter(moveStatus -> moveStatus)
                .forEach(moveStatus -> carPosition.append(POSITION_CURSOR));

        return carPosition.toString();
    }
}
