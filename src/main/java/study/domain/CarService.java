package study.domain;

import study.repository.CarRepository;

import java.util.List;

public class CarService {

    private final CarRepository memoryCarRepository;

    public CarService(CarRepository memoryCarRepository) {
        this.memoryCarRepository = memoryCarRepository;
    }

    public Car join(Car car) {
        return memoryCarRepository.save(car);
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

}
