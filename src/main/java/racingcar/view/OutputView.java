package racingcar.view;

import racingcar.RoundRecord;
import racingcar.RoundRecords;

import java.io.PrintStream;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String MOVEMENT_CHAR = "-";

    public static void showResult(RoundRecords roundRecords) {
        String result = roundRecords.getRoundRecordList().stream()
                .map(OutputView::roundRecordToString)
                .collect(Collectors.joining("\n\n"));

        out.println(result + "\n");
    }

    private static String roundRecordToString(RoundRecord roundRecord) {
        return roundRecord.getRecord().entrySet().stream()
                .map(OutputView::changeRecordToString)
                .collect(Collectors.joining("\n"));
    }

    private static String changeRecordToString(Map.Entry<String, Integer> positions) {
        return positions.getKey() + " : " + new String(new char[positions.getValue()]).replace("\0", MOVEMENT_CHAR);
    }
}
