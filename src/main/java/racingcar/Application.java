package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());
        RacingGameController racingGameController = new RacingGameController(carService);
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