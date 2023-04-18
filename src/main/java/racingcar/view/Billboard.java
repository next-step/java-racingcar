package racingcar.view;

import racingcar.dto.CarResult;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class Billboard {

    private static final String POSITION_SEPARATOR = "-";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";

    private static final String NOTICE_MENT = "실행 결과";

    private Billboard() {
    }

    public static void printGameResult(final GameResult gameResult) {
        notice();
        for (final RoundResult roundResult : gameResult.getRoundResults()) {
            printRoundResult(roundResult);
            lineBreak();
        }
        printWinners(gameResult.getWinners());
    }

    private static void printRoundResult(final RoundResult roundResult) {
        for(final CarResult carResult : roundResult.getResult()) {
            printPosition(carResult);
        }
    }

    private static void printPosition(final CarResult carResult) {
        System.out.println(carResult.getName() + RESULT_SEPARATOR + POSITION_SEPARATOR.repeat(carResult.getPosition()));
    }

    private static void printWinners(final List<CarResult> winners) {
        String winnerNames = winners.stream()
                .map(CarResult::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));
        System.out.println(String.format(WINNER_FORMAT, winnerNames));
    }

    private static void notice() {
        System.out.println(NOTICE_MENT);
    }

    private static void lineBreak() {
        System.out.println();
    }

}
