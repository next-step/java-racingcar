package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.dto.CarDto;
import racingcar.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(String name) {
        carRepository.save(new Car(name));
    }

    public List<CarDto> findCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> new CarDto(car.getPosition(), car.getName()))
                .collect(Collectors.toList());
    }

    public List<Integer> findCarsPosition() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> car.getPosition().toInteger())
                .collect(Collectors.toList());
    }

    public List<String> findCarsName() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> car.getName().toString())
                .collect(Collectors.toList());
    }

    public List<String> findWinnersName(Position maxPosition) {
        List<Car> winners = carRepository.findWinnersByMaxPosition(maxPosition);
        return winners.stream()
                .map(car -> car.getName().toString())
                .collect(Collectors.toList());
    }

    public Position findMaxPosition() {
        return carRepository.findMaxPosition();
    }

    public Car findCar(Name name) {
        return carRepository.findByName(name);
    }

    public void moveCars() {
        carRepository.updateCarsPosition();
    }
}