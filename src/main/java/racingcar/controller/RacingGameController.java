package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.Queue;

public class RacingGameController {

    private static final String CHECK_INPUT_INTEGER = "숫자를 입력해주세요.";
    private static final String CHECK_INPUT_NULL = "null 값인지 확인해주세요.";
    private static final String CHECK_INPUT_EMPTY = "비어있는 값인지 확인해주세요.";
    private static final String CHECK_INPUT_INCLUDE_DASH = "\",\"가 포함되어 있는지 확인해주세요.";
    private static final String DELEMETER = ",";
    private final CarService carService;
    private final GameRoundService gameRoundService;

    public RacingGameController(CarService carService, GameRoundService gameRoundService) {
        this.carService = carService;
        this.gameRoundService = gameRoundService;
    }

    public void run() {
        setGameEnvironment();
        printGameResult();
        printWinners();
    }

    public void setGameEnvironment() {
        String nameOfCars = InputView.INSTANCE.InputNameOfCars();
        validateInput(nameOfCars);
        createCars(nameOfCars.split(DELEMETER));
        String numberOfAttempts = InputView.INSTANCE.InputNumberOfAttempts();
        validateNumber(numberOfAttempts);
        createGameRound(Integer.parseInt(numberOfAttempts));
    }

    public void createCars(String[] namesOfCar) {
        Arrays.stream(namesOfCar)
                .forEach(name -> carService.addCar(name.trim()));
    }

    public void createGameRound(int numberOfAttempts) {
        gameRoundService.create(numberOfAttempts);
    }

    public void raceEachRound() {
        carService.moveCars();
    }

    public void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRoundService.loadGameRound().getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(
                    carService.findNameOfCars(),
                    carService.findMovementRangeOfCars()
            );
        }
    }

    private void printWinners() {
        int maxMovementRange = carService.findMaxMovementRange();
        Queue<String> winners = carService.findWinners(maxMovementRange);
        ResultView.INSTANCE.printWinners(winners);
    }

    public void resetMovementRangeOfCar(String carName) {
        carService.resetCarMovementRange(carName);
    }

    public void resetMovementRangeOfCars() {
        carService.resetCarsMovementRange();
    }

    private void validateNumber(String input) {
        validateNull(input);
        validateEmpty(input);
        validateInteger(input);
    }

    private void validateInput(String input) {
        validateNull(input);
        validateEmpty(input);
        validateDash(input);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHECK_INPUT_INTEGER);
        }
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CHECK_INPUT_NULL);
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CHECK_INPUT_EMPTY);
        }
    }

    private void validateDash(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(CHECK_INPUT_INCLUDE_DASH);
        }
    }
}
