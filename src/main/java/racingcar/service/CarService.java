package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

public enum CarService {

    INSTANCE;

    private final CarRepository carRepository = CarRepository.INSTANCE;

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> findCars() {
        return carRepository.findAll();
    }

    public List<Integer> findMovementRangeOfCars() {
        return carRepository.findAllMovementRange();
    }

    public Car findCar(String name) {
        return carRepository.findByName(name);
    }
}