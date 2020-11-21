package racing.view;

import java.util.List;

import static util.StringUtils.repeat;

import racing.domain.Record;
import util.StringUtils;

public final class ResultView {

    private static final String RACING_RESULT = "실행 결과";

    private static final String DISPLACEMENT_SYMBOL = "-";

    public static final String DELIMITER = " : ";

    public static final String WIN_MESSAGE = " 가 최종 우승했습니다";

    private ResultView() {}

    public static void viewMessage() {
        System.out.println(RACING_RESULT);
    }

    public static void viewRoundResult(final List<Record> records) {
        for (Record record : records) {
            String name = record.getName();
            int position = record.getPosition();

            System.out.println(name + DELIMITER + repeat(DISPLACEMENT_SYMBOL, position));
        }

        System.out.println();
    }

    public static void viewWinner(final List<String> winners) {
        String winnersHasNoBrackets = StringUtils.removeBrackets(winners.toString());

        System.out.println(winnersHasNoBrackets + WIN_MESSAGE);
    }
}
