package racinggame.domain;

import racinggame.dto.WinCarsDTO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<WinCarsDTO> winners() {
        return cars.stream()
                .collect(groupingBy(Car::getCarDistance, Collectors.mapping(WinCarsDTO::new, toList())))
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getKey().getDistance()))
                .get()
                .getValue()
                .stream()
                .collect(toList());
    }
}
