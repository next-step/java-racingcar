package racingcar.view;

import racingcar.domain.Record;
import racingcar.domain.Records;

import java.util.List;

public class ResultView {

    private static final String DASH = "-";
    private static final String RESULT = "실행 결과";

    /**
     * 게임 진행 결과를 출력한다.
     *
     * @param records
     */
    public static void print(List<Records> records) {
        System.out.println(RESULT);

        for (Records record : records) {
            printRecord(record);
            System.out.println();
        }
    }

    private static void printRecord(final Records records) {
        for (Record record : records.getRecords()) {
            mergePrint(record);
            System.out.println();
        }
    }

    private static void mergePrint(Record record) {
        printName(record);
        System.out.print(" ");
        printDistance(record);
    }

    private static void printName(final Record record) {
        for (int i = 0; i < record.getName().length(); i++) {
            System.out.print(record.getName() + " :");
        }
    }

    private static void printDistance(final Record record) {
        for (int i = 0; i < record.getDistance(); i++) {
            System.out.print(DASH);
        }
    }
}
