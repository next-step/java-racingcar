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
        int setNumberOfMoves = InputView.setNumberOfMoves();
        RacingCar racingCar = new RacingCar(memoryCarRepository);

        // business logic
        ResultView.beforeRacingPrintMessage();
        racingCar.setCarName(carNames);
        for (int i = 0; i < setNumberOfMoves; i++) {
            ResultView.printCarNamesAndResults(racingCar.racing());
        }
        ResultView.printFinalWinnerNames(racingCar.findWinner());
    }
}
