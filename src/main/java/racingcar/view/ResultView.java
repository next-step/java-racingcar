package racingcar.view;

import racingcar.domain.RacingResult;
import util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class ResultView {
    private static final String RACE_TRACK = "-";
    private static final String DELIMITER = " : ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void print(RacingResult racingResult) {
        System.out.println(RESULT_MESSAGE);

        printResultByAttempt(racingResult);
        printWinner(racingResult);
    }

    private static void printWinner(RacingResult racingResult) {
        int lastAttempt = racingResult.getAttempt() - 1;

        System.out.println(racingResult.getWinner() + WINNER_MESSAGE);
    }

    private static void printResultByAttempt(RacingResult racingResult) {
        Stream.iterate(0, attempt -> attempt + 1)
                .limit(racingResult.getAttempt())
                .map(racingResult::getResultByAttempt)
                .map(ResultView::makeResultMessage)
                .forEach(ResultView::printResultByAttempt);
    }

    private static List<String> makeResultMessage(Map<String, Integer> resultByAttempt) {
        return resultByAttempt.keySet()
                .stream()
                .map(name -> name
                        + DELIMITER
                        + StringUtils.repeat(RACE_TRACK, resultByAttempt.get(name)))
                .collect(Collectors.toList());
    }

    private static void printResultByAttempt(List<String> resultByAttempt) {
        resultByAttempt.forEach(System.out::println);
        System.out.println();
    }
}
