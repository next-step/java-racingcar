package racingcar.view;

import racingcar.RacingResult;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void print(RacingResult racingResult) {
        System.out.println(RESULT_MESSAGE);

        printResultByAttempt(racingResult);
        printWinner(racingResult);
    }

    private static void printWinner(RacingResult racingResult) {
        int lastAttempt = racingResult.getAttempt() - 1;

        System.out.println(racingResult.getWinner(lastAttempt) + WINNER_MESSAGE);
    }

    private static void printResultByAttempt(RacingResult racingResult) {
        Stream.iterate(0, attempt -> attempt + 1)
                .limit(racingResult.getAttempt())
                .map(racingResult::getResultByAttempt)
                .forEach(ResultView::printResultByAttempt);
    }

    private static void printResultByAttempt(List<String> resultByAttempt) {
        resultByAttempt.forEach(System.out::println);
        System.out.println();
    }
}
