package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.RoundRecord;
import racingcar.domain.RoundRecords;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String MOVEMENT_CHAR = "-";
    private static final String WINNERS_MESSAGE_SUFFIX = "가 최종 우승했습니다.";
    private static final String WINNERS_JOINING_UNIT = ",";

    private OutputView() {
    }

    public static void showResult(GameResult gameResult) {
        printRoundRecords(gameResult.getRoundRecords());
        printWinners(gameResult.getWinnerNames());
    }

    private static void printWinners(List<String> winners) {
        String winnerStr = String.join(WINNERS_JOINING_UNIT, winners);

        out.println(winnerStr + WINNERS_MESSAGE_SUFFIX);
    }

    private static void printRoundRecords(RoundRecords roundRecords) {
        String result = roundRecords.getRoundRecordList().stream()
                .map(OutputView::getRoundRecordString)
                .collect(Collectors.joining("\n\n"));

        out.println(result + "\n");
    }

    private static String getRoundRecordString(RoundRecord roundRecord) {
        return roundRecord.getRecord().entrySet().stream()
                .map(OutputView::getRecordString)
                .collect(Collectors.joining("\n"));
    }

    private static String getRecordString(Map.Entry<String, Integer> positions) {
        return positions.getKey() + " : " + new String(new char[positions.getValue()]).replace("\0", MOVEMENT_CHAR);
    }
}
