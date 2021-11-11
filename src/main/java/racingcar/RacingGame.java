package racingcar;

import java.util.stream.IntStream;

import static util.StringUtils.separateStringWithComma;

public class RacingGame {
    private final static int FIRST_ROUND = 1;
    private static final int LIMIT_OF_CAR_NAME = 5;

    public static void run() {
        InputView inputView = new ConsoleInputView();

        String identifierOfCars = inputView.getIdentifierOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        String[] namesOfCars = separateStringWithComma(identifierOfCars);
        checkCarNames(namesOfCars);
        CarFactory carFactory = new CarFactory(namesOfCars);
        Cars cars = carFactory.buildCars();

        OutputView outputView = new ConsoleOutputView();

        outputView.showOutputMessage();
        IntStream.rangeClosed(FIRST_ROUND, numberOfTrials)
                .forEach(roundNumber -> eachRound(outputView, roundNumber, cars));

        Cars winners = cars.chooseWinner();
        outputView.showWinners(winners);
    }

    private static void eachRound (OutputView outputView, int roundNumber, Cars cars) {
        outputView.showStartOfRound(roundNumber);
        cars.progressRound();
        outputView.showRacing(cars);
        outputView.showEndOfRound(roundNumber);
    }

    private static void checkCarNames(String[] carNames) {
        if (carNames.length > LIMIT_OF_CAR_NAME)
            throw new IllegalArgumentException("The Length of Car Name must be below five");
    }
}
