package racing.dto;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EntireCars {

    private List<Car> cars = new ArrayList<>();

    public static EntireCars createCars(List<String> carNames) {

        EntireCars entireCars = new EntireCars();
        entireCars.cars = carNames.stream()
                .map(Car::of)
                .collect(Collectors.toList());

        return entireCars;
    }

    public Stream<Car> stream() {

        return cars.stream();
    }
}
