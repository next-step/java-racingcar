package racingcar.view;

import racingcar.RacingResult;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void print(RacingResult racingResult) {
        System.out.println(LINE_SEPARATOR + "실행 결과");

        Stream.iterate(0, attempt -> attempt + 1)
                .limit(racingResult.getAttempt())
                .map(racingResult::getResultByAttempt)
                .forEach(ResultView::printResultByAttempt);
    }

    private static void printResultByAttempt(List<String> resultByAttempt) {
        resultByAttempt.forEach(System.out::println);
        System.out.print(LINE_SEPARATOR);
    }
}
