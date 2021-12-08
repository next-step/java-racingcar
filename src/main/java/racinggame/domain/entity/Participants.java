package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public List<Location> play(MovingStrategy movingStrategy) {
        return cars.stream()
                .map(c -> c.play(movingStrategy))
                .collect(Collectors.toList());
    }

    public void reportCurrentStatus(Car.ReportingCar reportingCar) {
        cars.forEach(c -> c.report(reportingCar));
    }

    public List<Car> rankTop() {
        Car oneOfTop = cars.stream().max((Comparator.comparing(Car::getLocation))).get();
        return cars.stream().filter(c -> c.getLocation().equals(oneOfTop.getLocation())).collect(Collectors.toList());
    }
}
