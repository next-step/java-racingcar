package study.domain;

import study.repository.CarRepository;
import study.utils.RandomUtils;
import study.view.ResultView;

import java.util.List;

public class RacingCar {
    private final int numberOfMoves;
    private final String[] nameOfCars;
    private final CarService carService;

    public RacingCar(String[] nameOfCars, int numberOfMoves, CarRepository memoryCarRepository) {
        this.nameOfCars = nameOfCars;
        this.numberOfMoves = numberOfMoves;
        this.carService = new CarService(memoryCarRepository);
    }

    public void startRacing() {
        carService.setCarListByName(nameOfCars);
        List<Car> cars = carService.findAllCars();
        for (int i = 0; i < numberOfMoves; i++) {
            for (Car car : cars) {
                car.moving(RandomUtils.getRandomNumberZeroToNine());
            }
            ResultView.printCarNameAndRacingResult(cars);
        }
    }

    public List<Car> findWinner() {
        return Winner.findWinner(carService.findAllCars());
    }
}
