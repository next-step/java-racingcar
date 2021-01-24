package racingcar;

import java.util.Scanner;
import racingcar.controller.GameController;
import racingcar.domain.RacingGame;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        CarRepository carRepository = new CarRepository();

        carRepository.createCars(inputView.inputCarNames(scanner));
        RacingGame racingGame = new RacingGame(inputView.inputGameTryCnt(scanner));

        GameController gameController = new GameController(carRepository, racingGame);
        gameController.playGame();

        ResultView resultView = new ResultView();
        resultView.printResult();
    }
}
