package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRoundRepository;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());
        GameRoundService gameRoundService = new GameRoundService(new GameRoundRepository());
        RacingGameController racingGameController = new RacingGameController(carService, gameRoundService);
        racingGameController.run();
    }
}