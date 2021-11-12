package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class RacingGame {
    private final static int FIRST_ROUND = 1;

    private static final String COMMA = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static void run() {
        InputView inputView = new ConsoleInputView();

        String identifierOfCars = inputView.getIdentifierOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        String[] namesOfCars = separateStringWithComma(identifierOfCars);
        CarFactory carFactory = new CarFactory(namesOfCars);
        Cars cars = carFactory.buildCars();

        OutputView outputView = new ConsoleOutputView();

        outputView.showOutputMessage();
        IntStream.rangeClosed(FIRST_ROUND, numberOfTrials)
                .forEach(roundNumber -> eachRound(outputView, roundNumber, cars));

        Winners winners = cars.chooseWinner();
        outputView.showWinners(winners);
    }

    private static void eachRound (OutputView outputView, int roundNumber, Cars cars) {
        outputView.showStartOfRound(roundNumber);
        cars.progressRound();
        outputView.showRacing(cars);
        outputView.showEndOfRound(roundNumber);
    }

    private static String[] separateStringWithComma(String string) {
        return string.replaceAll(REGEX_WHITESPACE, EMPTY_STRING).split(COMMA);
    }
}
