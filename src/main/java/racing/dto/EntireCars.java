package racing.dto;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import static racing.service.RacingService.START_UNIQUE_CAR_NUMBER;

public class EntireCars {

    private List<Car> cars = new ArrayList<>();

    public static EntireCars createCars(int carCount) {

        EntireCars entireCars = new EntireCars();
        entireCars.cars = IntStream.rangeClosed(START_UNIQUE_CAR_NUMBER, carCount)
                .mapToObj(Car::of)
                .collect(Collectors.toList());

        return entireCars;
    }

    public Stream<Car> stream() {

        return cars.stream();
    }
}
