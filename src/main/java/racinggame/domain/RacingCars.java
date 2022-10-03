package racinggame.domain;

import racinggame.dto.WinCarsDTO;

import java.util.List;
import java.util.Map;
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
                .collect(groupingBy(Car::distance, Collectors.mapping(WinCarsDTO::new, toList())))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .get()
                .getValue()
                .stream()
                .collect(toList());
    }
}
