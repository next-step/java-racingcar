package racingcar;

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
        for (final RaceResult raceResult : gameResult.getRaceResults()) {
            printRoundResult(raceResult);
            lineBreak();
        }
        printWinners(gameResult.getWinners());
    }

    private static void printRoundResult(final RaceResult raceResult) {
        for(final CarResult carResult : raceResult.getResult()) {
            printPosition(carResult);
            lineBreak();
        }
    }

    private static void printPosition(final CarResult carResult) {
        StringBuilder positionSeparator = new StringBuilder();
        for (int i = 0; i < carResult.getPosition(); i++) {
            positionSeparator.append(POSITION_SEPARATOR);
        }
        System.out.print(carResult.getName() + RESULT_SEPARATOR + positionSeparator);
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
