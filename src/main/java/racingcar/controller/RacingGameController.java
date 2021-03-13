package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameRound;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    private final CarService carService;
    private final GameRoundService gameRoundService;

    public RacingGameController(CarService carService, GameRoundService gameRoundService) {
        this.carService = carService;
        this.gameRoundService = gameRoundService;
    }

    public void run() {
        setGameEnvironment();
        printGameResult();
    }

    public void setGameEnvironment() {
        String numberOfCars = InputView.INSTANCE.InputNumberOfCars();
        validateNumber(numberOfCars);
        createCars(Integer.parseInt(numberOfCars));
        String numberOfAttempts = InputView.INSTANCE.InputNumberOfAttempts();
        validateNumber(numberOfAttempts);
        createGameRound(Integer.parseInt(numberOfAttempts));
    }

    public void createCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            carService.addCar(new Car((Integer.toString(i))));
        }
    }

    public void createGameRound(int numberOfAttempts) {
        gameRoundService.create(new GameRound(numberOfAttempts));
    }

    public void raceEachRound() {
        carService.findCars().forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRoundService.loadGameRound().getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(carService.findMovementRangeOfCars());
        }
    }

    private void validateNumber(String input) {
        validateNull(input);
        validateEmpty(input);
        validateInteger(input);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 값인지 확인해주세요.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("비어있는 값인지 확인해주세요.");
        }
    }
}
