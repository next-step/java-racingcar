package study;

import study.domain.RacingCar;
import study.repository.CarRepository;
import study.repository.MemoryCarRepository;
import study.view.InputView;
import study.view.ResultView;

import static study.utils.StringUtils.splitStringAndValidateNames;

public class RacingCarApplication {
    public static void main(String[] args) {
        CarRepository memoryCarRepository = new MemoryCarRepository();

        String setNameOfCars = InputView.setNameOfCars();
        String[] carNames = splitStringAndValidateNames(setNameOfCars);
        int setNumberOfMoves = InputView.setNumberOfMoves();
        RacingCar racingCar = new RacingCar(carNames, setNumberOfMoves, memoryCarRepository);

        // business logic
        ResultView.beforeRacingPrintMessage();
        racingCar.startRacing();
        ResultView.printWinnerCar(racingCar.findWinner());
    }
}
