package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService(new CarRepository());
        RacingGameController racingGameController = new RacingGameController(carService);
        racingGameController.run();
    }
}