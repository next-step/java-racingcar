package racingcar.view;

import racingcar.domain.Record;
import racingcar.domain.Records;

public class ResultView {
    private final static String LOCATION_EXPRESSION = "-";
    private final static String SET_OUTPUT_RESULT = "실행 결과";

    public static void printStart() {
        System.out.println(SET_OUTPUT_RESULT);
    }

    public static void printRecords(Records records) {
        for (Record record : records.getRecords()) {
            printRecord(record);
            System.out.println();
        }
    }

    private static void printRecord(Record record) {
        for (String output : record.getRecord()) {
            System.out.println(output);
        }
    }
}
