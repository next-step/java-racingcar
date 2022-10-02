package racingcar.view;

import racingcar.backend.domain.GameRecords;
import racingcar.backend.domain.GameRecord;

import java.util.stream.Collectors;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "_";
    private static final StringBuilder history = new StringBuilder();
    private static final String GAME_RESULT = "계임결과";

    private ResultView() {
        throw new AssertionError("No instance");
    }

    public static void printGameHistory(GameRecords gameHistory) {
        history.append(GAME_RESULT);
        history.append(NEW_LINE);
        for (GameRecord gameRecord : gameHistory.getValues()) {
            history.append(NEW_LINE);
            history.append(gameRecordToString(gameRecord));
            history.append(NEW_LINE);
        }
        print(history.toString());
    }

    public static String gameRecordToString(GameRecord gameRecord) {
        return gameRecord.getValues().stream()
                .map(POSITION_MARK::repeat)
                .collect(Collectors.joining(NEW_LINE));
    }

    private static void print(String result) {
        System.out.println(result);
    }
}
