package racingcar.view;

import racingcar.Record;
import racingcar.Records;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String MOVEMENT_CHAR = "-";

    public static void showResult(Records records) {
        String result = records.getRecordList().stream()
                .map(OutputView::recordToString)
                .collect(Collectors.joining("\n\n"));

        out.println(result + "\n");
    }

    private static String recordToString(Record record) {
        return record.getPositions().stream()
                .map(OutputView::changeMovementToString)
                .collect(Collectors.joining("\n"));
    }

    private static String changeMovementToString(int num) {
        return new String(new char[num]).replace("\0", MOVEMENT_CHAR);
    }
}
