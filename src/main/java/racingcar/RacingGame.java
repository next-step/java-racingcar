package racingcar;

import java.util.List;
import java.util.stream.IntStream;

import static util.StringUtils.separateStringWithComma;

public class RacingGame {
    private final static int FIRST_ROUND = 1;
    private final static int ROUND_INCREMENT = 1;

    public static void run() {
        InputView inputView = new ConsoleInputView();

        String identifierOfCars = inputView.getIdentifierOfCars();
        int numberOfTrials = inputView.getNumberOfTrials();

        String[] namesOfCars = separateStringWithComma(identifierOfCars);
        CarFactory carFactory = new CarFactory(namesOfCars);
        Cars cars = carFactory.buildCars();

        OutputView outputView = new ConsoleOutputView();

        RacingManager racingManager = new RacingManager(cars);

        outputView.showOutputMessage();
        IntStream.rangeClosed(FIRST_ROUND, numberOfTrials - ROUND_INCREMENT)
                .forEach(roundNumber -> eachRound(outputView, roundNumber, racingManager));
        List<CarState> resultOfLastRound = eachRound(outputView, numberOfTrials, racingManager);

        WinnerChooser winnerChooser = new WinnerChooser(resultOfLastRound);
        outputView.showWinners(winnerChooser.chooseWinner());
    }

    private static List<CarState> eachRound (OutputView outputView, int roundNumber, RacingManager racingManager) {
        outputView.showStartOfRound(roundNumber);
        List<CarState> progressOfCars = racingManager.progressRound();
        outputView.showRacing(progressOfCars);
        outputView.showEndOfRound(roundNumber);

        return progressOfCars;
    }
}
