package racing.view;

import racing.domain.RoundRecord;
import racing.domain.RoundRecords;

import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String POSITION_MARK = "_";
    private static final String PRINT_FORMAT = "{0} : {1}";

    public static void showResult(RoundRecords roundRecords) {
        StringBuilder printResult = new StringBuilder();
        printResult.append(GAME_RESULT);
        printResult.append(NEW_LINE);
        for (RoundRecord roundRecord : roundRecords.getValue()) {
            printResult.append(print(roundRecord));
            printResult.append(NEW_LINE);
            printResult.append(NEW_LINE);
        }
        printResult.append(findWinner(roundRecords)).append(WINNER_ANNOUNCEMENT);
        System.out.println(printResult.toString());
    }

    private static String print(RoundRecord roundRecord) {

        return roundRecord.getPositions().entrySet()
                .stream()
                .map(ResultView::makeMessageFormat)
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String makeMessageFormat(Map.Entry<String, Integer> position) {
        return MessageFormat.format(PRINT_FORMAT, position.getKey(), POSITION_MARK.repeat(Math.max(0, position.getValue())));
    }

    private static String findWinner(RoundRecords roundRecords) {
        return String.join(", ", roundRecords.findWinner());
    }
}
