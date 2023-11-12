package study.domain;

import study.repository.CarRepository;
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
        for (int i = 0; i < numberOfMoves; i++) {
            ResultView.printCarNamesAndResults(carService.racingCar());
        }
    }

    public List<Car> findWinner() {
        Winner winner = new Winner(carService.findAllCars());
        return winner.findWinner();
    }
}
