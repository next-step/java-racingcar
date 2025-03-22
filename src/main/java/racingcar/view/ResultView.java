package racingcar.view;

import racingcar.domain.Record;

import java.util.Comparator;
import java.util.List;

public class ResultView {

    public static final String DEFAULT_MARKER = "-";
    public static final String SEPARATOR = " : ";

    public void printResult(List<Record> records) {
        System.out.println();

        records.sort(
                Comparator.comparing(Record::getAttempt)
                        .thenComparing(Record::getName)
        );

        this.printPretty(records);

    }

    private void printPretty(List<Record> records) {
        StringBuilder result = new StringBuilder()
                .append("실행 결과")
                .append("\n");

        int prevAttempt = 1;
        for (Record record : records) {
            if (record.getAttempt() > prevAttempt) {
                result.append("\n");
                prevAttempt++;
            }

            result.append(makeFormat(record));
        }

        System.out.println(result);
    }

    private String makeFormat(Record record) {
        return record.getName() +
                SEPARATOR +
                DEFAULT_MARKER.repeat(record.getPosition()) + "\n";
    }


}
