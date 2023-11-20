package study.controller;

import study.service.RacingCar;
import study.repository.CarRepository;
import study.repository.MemoryCarRepository;
import study.view.InputView;
import study.view.ResultView;

import static study.util.SplitName.splitStringAndValidateNames;

public class RacingCarApplication {
    public static void main(String[] args) {
        CarRepository memoryCarRepository = new MemoryCarRepository();

        String setNameOfCars = InputView.setNameOfCars();
        String[] carNames = splitStringAndValidateNames(setNameOfCars);
        RacingCar racingCar = new RacingCar(memoryCarRepository);
        racingCar.setCarName(carNames);
        int setNumberOfMoves = InputView.setNumberOfMoves();

        // business logic
        ResultView.beforeRacingPrintMessage();
        for (int i = 0; i < setNumberOfMoves; i++) {
            ResultView.printCarNamesAndResults(racingCar.racing());
        }
        ResultView.printFinalWinnerNames(racingCar.findWinner());
    }
}
