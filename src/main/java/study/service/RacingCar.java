package study.service;

import study.domain.Car;
import study.domain.Winner;
import study.repository.CarRepository;

import java.util.List;

public class RacingCar {
    private final CarService carService;

    public RacingCar(CarRepository memoryCarRepository) {
        this.carService = new CarService(memoryCarRepository);
    }

    public void setCarName(String[] carName) {
        carService.setCarListByName(carName);
    }
    public List<Car> racing() {
        return carService.racingCar();
    }

    public List<Car> findWinner() {
        Winner winner = new Winner(carService.findAllCars());
        return winner.findWinner();
    }
}
