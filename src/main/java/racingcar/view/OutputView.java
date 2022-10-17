package racingcar.view;

import java.util.List;
import racingcar.model.Distance;

public final class OutputView {

    private static final int DIVIDER_LINE_NO = 1;
    private static final String LINE_STYLE = "-";
    private static final String GAME_RESULT_TITLE_MESSAGE = "실행 결과";

    private OutputView() {
    }

    public static void printGameResultTitle() {
        print(GAME_RESULT_TITLE_MESSAGE);
    }

    public static void printDivider() {
        printEmptyLine(DIVIDER_LINE_NO);
    }

    public static void printCarDistances(final List<Distance> carDistances) {
        if (carDistances == null || carDistances.isEmpty()) {
            return;
        }
        for (final Distance carDistance : carDistances) {
            printDistance(carDistance);
        }
    }

    private static void printDistance(final Distance carDistance) {
        if (carDistance == null) {
            return;
        }
        print(convertDistanceToLine(carDistance));
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