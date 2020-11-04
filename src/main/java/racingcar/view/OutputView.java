package racingcar.view;

import racingcar.Record;
import racingcar.Records;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String MOVEMENT_CHAR = "-";

    public void showResult(Records records) {
        String result = records.getRecordList().stream()
                .map(this::recordToString)
                .collect(Collectors.joining("\n"));

        out.println(result + "\n");
    }

    private String recordToString(Record record) {
        return record.getPositions().stream()
                .map(this::changeMovementToString)
                .collect(Collectors.joining("\n"));
    }

    private String changeMovementToString(int num) {
        return new String(new char[num]).replace("\0", MOVEMENT_CHAR);
    }
}
