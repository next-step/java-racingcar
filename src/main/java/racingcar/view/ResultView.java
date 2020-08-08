package racingcar.view;

import racingcar.RacingResult;
import util.StringUtils;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RACE_TRACK = "-";

    public static void print(RacingResult racingResult) {
        System.out.println(LINE_SEPARATOR + "실행 결과");

        Stream.iterate(0, attempt -> attempt + 1)
                .limit(racingResult.getAttempt())
                .map(racingResult::getResultByAttempt)
                .forEach(ResultView::printResultByAttempt);
    }

    private static void printResultByAttempt(List<Integer> resultByAttempt) {
        resultByAttempt.stream()
                .map(ResultView::makeRaceRecord)
                .forEach(System.out::print);

        System.out.println(LINE_SEPARATOR);
    }

    private static String makeRaceRecord(Integer log) {
        return StringUtils.repeat(RACE_TRACK, log) + LINE_SEPARATOR;
    }
}
