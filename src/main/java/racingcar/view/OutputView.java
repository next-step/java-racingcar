package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarName;
import racingcar.model.CarStatus;
import racingcar.model.Distance;

public final class OutputView {

    private static final int DIVIDER_LINE_NO = 1;
    private static final String LINE_STYLE = "-";
    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String GAME_RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String GAME_WINNERS_SUFFIX_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printWinners(final List<CarName> winnerCarNames) {
        print(createWinnersMessage(winnerCarNames));
    }

    public static void printGameResultTitle() {
        print(GAME_RESULT_TITLE_MESSAGE);
    }

    public static void printDivider() {
        printEmptyLine(DIVIDER_LINE_NO);
    }

    private static String createWinnersMessage(final List<CarName> winnerCarNames) {
        return new StringBuilder()
            .append(createWinnersTitleMessage(winnerCarNames))
            .append(GAME_WINNERS_SUFFIX_MESSAGE)
            .toString();
    }

    private static String createWinnersTitleMessage(final List<CarName> winnerCarNames) {
        return winnerCarNames.stream()
            .map(CarName::getValue)
            .collect(Collectors.joining(COMMA + SPACE));
    }

    public static void printCarStatuses(final List<CarStatus> carStatuses) {
        if (carStatuses == null || carStatuses.isEmpty()) {
            return;
        }
        for (final CarStatus carStatus : carStatuses) {
            print(createCarStatusMessage(carStatus));
        }
    }

    private static String createCarStatusMessage(final CarStatus carStatus) {
        return new StringBuilder()
            .append(createCarStatusTitleMessage(carStatus))
            .append(createCarStatusBodyMessage(carStatus))
            .toString();
    }

    private static String createCarStatusTitleMessage(final CarStatus carStatus) {
        return new StringBuilder()
            .append(carStatus.getName().getValue())
            .append(SPACE).append(COLON).append(SPACE)
            .toString();
    }

    private static String createCarStatusBodyMessage(final CarStatus carStatus) {
        return convertDistanceToLine(carStatus.getDistance());
    }

    private static String convertDistanceToLine(final Distance carDistance) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Distance i = Distance.ZERO; i.isLessThan(carDistance); i = i.plus(Distance.ONE)) {
            stringBuilder.append(LINE_STYLE);
        }
        return stringBuilder.toString();
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    private static void printEmptyLine(final int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }
}