package study.service;

import study.domain.Car;
import study.repository.CarRepository;
import study.util.RandomNumberGenerator;

import java.util.List;

public class CarService {

    private final CarRepository memoryCarRepository;

    public CarService(CarRepository memoryCarRepository) {
        this.memoryCarRepository = memoryCarRepository;
    }

    public void join(Car car) {
        memoryCarRepository.save(car);
    }

    public Car findOneCar(Car car) {
        return memoryCarRepository.findCarByName(car);
    }

    public List<Car> findAllCars() {
        return memoryCarRepository.findCarAll();
    }

    public void setCarListByName(String[] names) {
        for (String carName : names) {
            Car car = new Car(carName);
            join(car);
        }
    }

    public List<Car> racingCar() {
        List<Car> cars = findAllCars();
        for (Car car : cars) {
            car.moving(RandomNumberGenerator.getRandomNumber());
        }
        return cars;
    }
}
