package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.repository.CarRepository;

public class GameController {
    private CarRepository carRepository;
    private GameService gameService;

    public GameController(CarRepository carRepository, RacingGame racingGame) {
        this.carRepository = carRepository;
        this.gameService = new GameService(carRepository.getCarList(), racingGame.getTryCnt());
    }

    public void playGame() {
        gameService.start();
    }
}