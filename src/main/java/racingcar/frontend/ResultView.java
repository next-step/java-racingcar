package racingcar.frontend;

import racingcar.backend.domain.GameRecords;
import racingcar.backend.domain.GameRecord;

import java.util.stream.Collectors;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";
    private static final String POSITION_MARK = "_";
    private static final StringBuilder history = new StringBuilder();
    private static final String GAME_RESULT = "게임결과";

    private ResultView() {
        throw new AssertionError("No instance");
    }

    public static void printGameHistory(GameRecords gameRecords) {
        history.append(GAME_RESULT);
        assembleGameRecords(gameRecords);
        assembleFinalWinner(gameRecords);
        gameResultPrint();
    }

    private static void gameResultPrint() {
        System.out.println(history.toString());
    }

    private static void assembleGameRecords(GameRecords gameRecords) {
        history.append(NEW_LINE);
        for (GameRecord gameRecord : gameRecords.getValues()) {
            history.append(NEW_LINE);
            history.append(gameRecordToString(gameRecord));
            history.append(NEW_LINE);
        }
        history.append(NEW_LINE);
    }

    private static void assembleFinalWinner(GameRecords gameRecords) {
        history.append(String.join(COMMA, gameRecords.finalWinner()));
        history.append("최종 우승했습니다.");
        history.append(NEW_LINE);
    }

    private static String gameRecordToString(GameRecord gameRecord) {
        return gameRecord.getValues()
                .stream()
                .flatMap(e -> e.entrySet().stream())
                .map(e -> e.getKey() + " : " + POSITION_MARK.repeat(e.getValue()))
                .collect(Collectors.joining(NEW_LINE));
    }
}
