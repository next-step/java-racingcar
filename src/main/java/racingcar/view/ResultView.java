package racingcar.view;

import racingcar.domain.Record;
import racingcar.domain.Records;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String RESULT = "실행 결과";

    public static void print(List<Records> records) {
        System.out.println(RESULT);

        for (Records record : records) {
            printRecord(record);
            System.out.println();
        }
    }

    private static void printRecord(final Records records) {
        for (Record record : records.getRecords()) {
            printDistance(record);
            System.out.println();
        }
    }

    private static void printDistance(final Record record) {
        for (int i = 0; i < record.getPosition(); i++) {
            System.out.print(DASH);
        }
    }
}
