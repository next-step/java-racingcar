package racing.view;

import racing.game.result.RacingResult;
import racing.game.result.RoundResult;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultView {

    private ResultView() {}

    private static final String RESULT = "\n실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String TRACE = "-";
    private static final String NAME_TRACE_DELIMITER = " : ";
    private static final String NAME_DELIMITER = ", ";


    public static void printResult(RacingResult result) {
        print(RESULT);
        printGameResult(result.roundResults());
        printWinner(result.winners());
    }


    private static void printGameResult(List<RoundResult> racingResult) {
        for (RoundResult roundResult : racingResult) {
            printRoundResult(roundResult);
            print("");
        }
    }

    private static void printWinner(List<String> winners) {
        print(nameOfWinners(winners) + WINNER_MESSAGE);
    }


    private static void printRoundResult(RoundResult roundResult) {
        for (String carName : roundResult.namesOfCar()) {
            print(carName + NAME_TRACE_DELIMITER + carTrace(roundResult, carName));
        }
    }

    private static String nameOfWinners(List<String> winners) {
        return String.join(NAME_DELIMITER, winners);
    }

    private static String carTrace(RoundResult roundResult, String carName) {
        return drawTrace(roundResult.positionOfCar(carName));
    }

    private static String drawTrace(int carPosition) {
        return TRACE.repeat(carPosition);
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
