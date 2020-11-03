package racingcar.view;

import racingcar.Record;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final PrintStream out = System.out;
    private static final String DISTANCE_UNIT = "-";

    public void showResult(List<Record> records) {
        String result = records.stream()
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
        return new String(new char[num]).replace("\0", DISTANCE_UNIT);
    }
}
