package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRoundRepository;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());
        GameRoundService gameRoundService = new GameRoundService(new GameRoundRepository());
        RacingGameController racingGameController = new RacingGameController(carService, gameRoundService);
        run(racingGameController);
    }

    public static void run(RacingGameController racingGameController) {
        setGameEnvironment(racingGameController);
        racingGameController.printGameResult();
    }

    public static void setGameEnvironment(RacingGameController racingGameController) {
        int numberOfCars = InputView.INSTANCE.InputNumberOfCars();
        racingGameController.createCars(numberOfCars);
        int numberOfAttempts = InputView.INSTANCE.InputNumberOfAttempts();
        racingGameController.createGameRound(numberOfAttempts);
    }
}