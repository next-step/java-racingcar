package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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