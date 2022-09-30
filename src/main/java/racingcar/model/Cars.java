package racingcar.model;

import racingcar.controller.CarStatusDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = initCars(names);
    }

    private List<Car> initCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<CarStatusDto> move() {
        cars.forEach(car -> car.move(new CarCondition()));
        return getCarStatus();
    }

    private List<CarStatusDto> getCarStatus() {
        List<CarStatusDto> carStatusDtos = new ArrayList<>();
        cars.forEach(car -> carStatusDtos.add(createCarStatusDto(car)));
        return carStatusDtos;
    }

    public List<CarStatusDto> getWinners() {
        return Car.getWinner(cars)
                .stream()
                .map(car -> new CarStatusDto(car.getPosition(), car.getName()))
                .collect(Collectors.toList());
    }

    private CarStatusDto createCarStatusDto(Car car) {
        return new CarStatusDto(car.getPosition(), car.getName());
    }
}
