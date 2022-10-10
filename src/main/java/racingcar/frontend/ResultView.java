package racingcar.frontend;

import racingcar.backend.domain.GameRecord;
import racingcar.backend.domain.GameRecords;
import racingcar.backend.dto.CarDto;

import java.util.stream.Collectors;

public class ResultView {

    private static final String NEW_LINE = System.lineSeparator();
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
        history.append(gameWinnersToString(gameRecords));
        history.append("최종 우승했습니다.");
        history.append(NEW_LINE);
    }

    private static String gameRecordToString(GameRecord gameRecord) {
        return gameRecord.getValue()
                .stream()
                .map(CarDto -> CarDto.printName() + " : " + CarDto.printPosition(POSITION_MARK))
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String gameWinnersToString(GameRecords gameRecords) {
        return gameRecords.getWinner()
                .stream()
                .map(CarDto::printName)
                .collect(Collectors.joining(COMMA));
    }
}
