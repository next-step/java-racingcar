package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRoundRepository;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        CarService carService = new CarService(new CarRepository(cars));
        GameRoundService gameRoundService = new GameRoundService(new GameRoundRepository());
        RacingGameController racingGameController = new RacingGameController(carService, gameRoundService);
        racingGameController.run();
    }
}