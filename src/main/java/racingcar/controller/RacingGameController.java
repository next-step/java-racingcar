package racingcar.controller;

import racingcar.domain.Position;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {

    private static final String CHECK_INTEGER = "숫자를 입력해주세요.";
    private static final String CHECK_NULL = "null 값인지 확인해주세요.";
    private static final String CHECK_EMPTY = "비어있는 값인지 확인해주세요.";
    private static final String CHECK_INCLUDE_COMMA = "\",\"가 포함되어 있는지 확인해주세요.";
    private static final String COMMA = ",";
    private final CarService carService;
    private final GameRoundService gameRoundService;

    public RacingGameController(CarService carService, GameRoundService gameRoundService) {
        this.carService = carService;
        this.gameRoundService = gameRoundService;
    }

    public void run() {
        setCars();
        setGameRound();
        printGameResult();
        printWinners();
    }

    public void setCars() {
        try {
            String CarsName = InputView.INSTANCE.InputNameOfCars();
            validateName(CarsName);
            createCars(CarsName.split(COMMA));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCars();
        }
    }

    public void setGameRound() {
        try {
            String tryNumber = InputView.INSTANCE.InputNumberOfAttempts();
            validateNumber(tryNumber);
            createGameRound(Integer.parseInt(tryNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setGameRound();
        }
    }

    public void createCars(String[] CarsName) {
        Arrays.stream(CarsName)
                .forEach(name -> carService.addCar(name.trim()));
    }

    public void createGameRound(int numberOfAttempts) {
        gameRoundService.create(numberOfAttempts);
    }

    public void raceEachRound() {
        carService.moveCars();
    }

    private void printGameResult() {
        ResultView.INSTANCE.printResultStatement();

        for (int i = 0; i < gameRoundService.loadGameRound().getRound(); i++) {
            raceEachRound();
            ResultView.INSTANCE.printEachRoundResult(
                    carService.findCarsName(),
                    carService.findCarsPosition()
            );
        }
    }

    private void printWinners() {
        Position maxPosition = carService.findMaxPosition();
        List<String> winnersName = carService.findWinnersName(maxPosition);
        ResultView.INSTANCE.printWinners(winnersName);
    }

    private void validateName(String input) {
        checkNull(input);
        checkEmpty(input);
        checkComma(input);
    }

    private void validateNumber(String input) {
        checkNull(input);
        checkEmpty(input);
        checkInteger(input);
    }

    private void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CHECK_NULL);
        }
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CHECK_EMPTY);
        }
    }

    private void checkComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(CHECK_INCLUDE_COMMA);
        }
    }

    private void checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHECK_INTEGER);
        }
    }
}
